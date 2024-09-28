package com.fasterxml.jackson.module.kotlin.test.github

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.junit.Test
import kotlin.test.assertEquals

class Github562Test {
    private val jackson = ObjectMapper().registerModule(kotlinModule())

    val json = """
        {
            "payloadType": "perform",
            "header": "lol",
            "type": "sometype",
            "any_other_data": {
                "field1": "1",
                "field2": "",
                "field3": "",
                "field4": {
                    "field5": "",
                    "field6": "",
                    "field7": "anytext"
                }
            }
        }
    """.trimIndent()


    data class Request(
        val payloadType: String,
        @JsonAnySetter
        @JsonAnyGetter
        val additionProperties: Map<String, Any?>? = null,
    ) {}

    @Test
    fun testDeserHit562() {
        val value: Request = jackson.readValue(json, Request::class.java)
        // Fixed
        assertEquals(3, value.additionProperties!!.size)
    }

}