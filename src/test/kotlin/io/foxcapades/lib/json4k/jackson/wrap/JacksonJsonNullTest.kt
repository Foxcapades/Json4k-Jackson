package io.foxcapades.lib.json4k.jackson.wrap

import io.foxcapades.lib.json4k.JsonElementContractTest
import io.foxcapades.lib.json4k.JsonElementType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("JacksonJsonNull")
class JacksonJsonNullTest : JsonElementContractTest() {

  override val expectedType = JsonElementType.Null

  override val targets = arrayOf(JacksonJsonNull())

  @Nested
  @DisplayName("#toJsonString()")
  inner class ToJsonString {

    val expected = arrayOf("null")

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expected[i], it.toJsonString())
    }
  }

  @Nested
  @DisplayName("#toPrettyJsonString()")
  inner class ToPrettyJsonString {

    val expected = arrayOf("null")

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expected[i], it.toPrettyJsonString())
    }
  }
}