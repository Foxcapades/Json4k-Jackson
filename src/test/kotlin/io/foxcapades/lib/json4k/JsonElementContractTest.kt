package io.foxcapades.lib.json4k

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("JsonElement Contract Test")
abstract class JsonElementContractTest {

  protected abstract val expectedType: JsonElementType

  protected abstract val targets: Array<out JsonElement>

  @Nested
  @DisplayName("JsonElement#type")
  inner class Type {

    @Test
    @DisplayName("returns the expected type")
    fun test1() = targets.forEach { assertEquals(expectedType, it.type) }
  }
}