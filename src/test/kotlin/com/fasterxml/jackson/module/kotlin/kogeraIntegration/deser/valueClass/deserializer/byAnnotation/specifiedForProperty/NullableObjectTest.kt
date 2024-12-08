package com.fasterxml.jackson.module.kotlin.kogeraIntegration.deser.valueClass.deserializer.byAnnotation.specifiedForProperty

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.kogeraIntegration.deser.valueClass.NullableObject
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.junit.jupiter.api.Test

@RunWith(Enclosed::class)
class NullableObjectTest {
    @Ignore
    companion object {
        val mapper = jacksonObjectMapper()
    }

    @Ignore
    data class NonNull(
        @get:JsonDeserialize(using = NullableObject.DeserializerWrapsNullable::class)
        val getterAnn: NullableObject,
        @field:JsonDeserialize(using = NullableObject.DeserializerWrapsNullable::class)
        val fieldAnn: NullableObject
    )

    class NonNullTest {
        @Test
        fun nonNull() {
            val result = mapper.readValue<NonNull>(
                """
                {
                  "getterAnn" : "foo",
                  "fieldAnn" : "bar"
                }
            """.trimIndent()
            )
            assertEquals(NonNull(NullableObject("foo-deser"), NullableObject("bar-deser")), result)
        }
    }

    @Ignore
    data class Nullable(
        @get:JsonDeserialize(using = NullableObject.DeserializerWrapsNullable::class)
        val getterAnn: NullableObject?,
        @field:JsonDeserialize(using = NullableObject.DeserializerWrapsNullable::class)
        val fieldAnn: NullableObject?
    )

    class NullableTest {
        @Test
        fun nonNullInput() {
            val result = mapper.readValue<Nullable>(
                """
                {
                  "getterAnn" : "foo",
                  "fieldAnn" : "bar"
                }
                """.trimIndent()
            )
            assertEquals(Nullable(NullableObject("foo-deser"), NullableObject("bar-deser")), result)
        }

        @Test
        fun nullInput() {
            val result = mapper.readValue<Nullable>(
                """
                {
                  "getterAnn" : null,
                  "fieldAnn" : null
                }
                """.trimIndent()
            )
            assertEquals(Nullable(null, null), result)
        }
    }
}
