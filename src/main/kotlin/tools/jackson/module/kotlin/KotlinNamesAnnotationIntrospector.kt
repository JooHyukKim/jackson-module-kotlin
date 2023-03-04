package tools.jackson.module.kotlin

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonCreator.Mode
import com.fasterxml.jackson.annotation.JsonProperty
import tools.jackson.databind.PropertyName
import tools.jackson.databind.cfg.MapperConfig
import tools.jackson.databind.introspect.Annotated
import tools.jackson.databind.introspect.AnnotatedConstructor
import tools.jackson.databind.introspect.AnnotatedField
import tools.jackson.databind.introspect.AnnotatedMember
import tools.jackson.databind.introspect.AnnotatedMethod
import tools.jackson.databind.introspect.AnnotatedParameter
import tools.jackson.databind.introspect.NopAnnotationIntrospector
import tools.jackson.databind.util.BeanUtil
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.util.Locale
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError
import kotlin.reflect.jvm.javaType
import kotlin.reflect.jvm.kotlinFunction

internal class KotlinNamesAnnotationIntrospector(val module: KotlinModule, val cache: ReflectionCache, val ignoredClassesForImplyingJsonCreator: Set<KClass<*>>) : NopAnnotationIntrospector() {
    override fun findImplicitPropertyName(config: MapperConfig<*>?, member: AnnotatedMember?): String? = when (member) {
        is AnnotatedMethod -> if (member.name.contains('-') && member.parameterCount == 0) {
            when {
                member.name.startsWith("get") -> member.name.substringAfter("get")
                member.name.startsWith("is") -> member.name.substringAfter("is")
                else -> null
            }?.replaceFirstChar { it.lowercase(Locale.getDefault()) }?.substringBefore('-')
        } else null
        is AnnotatedParameter -> findKotlinParameterName(member)
        else -> null
    }

    // since 2.11: support Kotlin's way of handling "isXxx" backed properties where
    // logical property name needs to remain "isXxx" and not become "xxx" as with Java Beans
    // (see https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html and
    //  https://github.com/FasterXML/jackson-databind/issues/2527
    //  for details)
    override fun findRenameByField(config: MapperConfig<*>,
                                   field: AnnotatedField,
                                   implName: PropertyName): PropertyName? {
        val origSimple = implName.simpleName
        if (field.declaringClass.isKotlinClass() && origSimple.startsWith("is")) {
            val mangledName: String? = BeanUtil.stdManglePropertyName(origSimple, 2)
            if ((mangledName != null) && !mangledName.equals(origSimple)) {
                return PropertyName.construct(mangledName)
            }
        }
        return null
    }

    @Suppress("UNCHECKED_CAST")
    private fun hasCreatorAnnotation(member: AnnotatedConstructor): Mode {
        // don't add a JsonCreator to any constructor if one is declared already
        val kClass = member.declaringClass.kotlin
            .apply { if (this in ignoredClassesForImplyingJsonCreator) return Mode.DISABLED }
        val kConstructor = cache.kotlinFromJava(member.annotated as Constructor<Any>) ?: return Mode.DISABLED

        // TODO:  should we do this check or not?  It could cause failures if we miss another way a property could be set
        // val requiredProperties = kClass.declaredMemberProperties.filter {!it.returnType.isMarkedNullable }.map { it.name }.toSet()
        // val areAllRequiredParametersInConstructor = kConstructor.parameters.all { requiredProperties.contains(it.name) }

        val propertyNames = kClass.memberProperties.map { it.name }.toSet()

        return when {
            kConstructor.isPossibleSingleString(propertyNames) -> Mode.DEFAULT
            kConstructor.parameters.any { it.name == null } -> Mode.DEFAULT
            !kClass.isPrimaryConstructor(kConstructor) -> Mode.DEFAULT
            else -> {
                val anyConstructorHasJsonCreator = kClass.constructors
                    .filterOutSingleStringCallables(propertyNames)
                    .any { it.hasAnnotation<JsonCreator>() }

                val anyCompanionMethodIsJsonCreator = member.type.rawClass.kotlin.companionObject?.declaredFunctions
                    ?.filterOutSingleStringCallables(propertyNames)
                    ?.any { it.hasAnnotation<JsonCreator>() && it.hasAnnotation<JvmStatic>() }
                    ?: false

                if (anyConstructorHasJsonCreator || anyCompanionMethodIsJsonCreator) {
                    Mode.DEFAULT
                } else {
                    Mode.PROPERTIES
                }
            }
        }
    }

    override fun findCreatorAnnotation(config: MapperConfig<*>?, a: Annotated?): Mode =
        if (a is AnnotatedConstructor && a.isKotlinConstructorWithParameters())
            cache.checkConstructorIsCreatorAnnotated(a) { hasCreatorAnnotation(it) }
        else
            Mode.DEFAULT

    @Suppress("UNCHECKED_CAST")
    private fun findKotlinParameterName(param: AnnotatedParameter): String? {
        return if (param.declaringClass.isKotlinClass()) {
            val member = param.owner.member
            if (member is Constructor<*>) {
                val ctor = (member as Constructor<Any>)
                val ctorParmCount = ctor.parameterTypes.size
                val ktorParmCount = try { ctor.kotlinFunction?.parameters?.size ?: 0 }
                catch (ex: KotlinReflectionInternalError) { 0 }
                catch (ex: UnsupportedOperationException) { 0 }
                if (ktorParmCount > 0 && ktorParmCount == ctorParmCount) {
                    ctor.kotlinFunction?.parameters?.get(param.index)?.name
                } else {
                    null
                }
            } else if (member is Method) {
                try {
                    val temp = member.kotlinFunction

                    val firstParamKind = temp?.parameters?.firstOrNull()?.kind
                    val idx = if (firstParamKind != KParameter.Kind.VALUE) param.index + 1 else param.index
                    val parmCount = temp?.parameters?.size ?: 0
                    if (parmCount > idx) {
                        temp?.parameters?.get(idx)?.name
                    } else {
                        null
                    }
                } catch (ex: KotlinReflectionInternalError) {
                    null
                }
            } else {
                null
            }
        } else {
            null
        }
    }
}

@Deprecated(
    "To be removed in 2.14",
    ReplaceWith("with(receiver) { declaringClass.declaredMethods.any { it.name.contains('-') } }")
)
private fun AnnotatedMethod.isInlineClass() = declaringClass.declaredMethods.any { it.name.contains('-') }

// if has parameters, is a Kotlin class, and the parameters all have parameter annotations, then pretend we have a JsonCreator
private fun AnnotatedConstructor.isKotlinConstructorWithParameters(): Boolean =
    parameterCount > 0 && declaringClass.isKotlinClass() && !declaringClass.isEnum

private fun KFunction<*>.isPossibleSingleString(propertyNames: Set<String>): Boolean = parameters.size == 1 &&
        parameters[0].name !in propertyNames &&
        parameters[0].type.javaType == String::class.java &&
        !parameters[0].hasAnnotation<JsonProperty>()

private fun Collection<KFunction<*>>.filterOutSingleStringCallables(propertyNames: Set<String>): Collection<KFunction<*>> =
    this.filter { !it.isPossibleSingleString(propertyNames) }

private fun KClass<*>.isPrimaryConstructor(kConstructor: KFunction<*>) = this.primaryConstructor.let {
    it == kConstructor || (it == null && this.constructors.size == 1)
}