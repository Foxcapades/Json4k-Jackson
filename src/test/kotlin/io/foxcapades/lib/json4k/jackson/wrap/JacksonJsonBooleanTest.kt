package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.BooleanNode
import io.foxcapades.lib.json4k.JsonElementContractTest
import io.foxcapades.lib.json4k.JsonElementType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("JacksonJsonBoolean")
internal class JacksonJsonBooleanTest : JsonElementContractTest() {

  override val expectedType = JsonElementType.Boolean

  override val targets = arrayOf(
    JacksonJsonBoolean(BooleanNode.TRUE),
    JacksonJsonBoolean(BooleanNode.FALSE),
  )

  @Nested
  @DisplayName("JsonBoolean#booleanValue()")
  inner class BooleanValue {

    val expects = arrayOf(true, false)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.booleanValue())
    }
  }

  @Nested
  @DisplayName("JsonBoolean#toJsonString()")
  inner class ToJsonString {

    val expects = arrayOf("true", "false")

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.toJsonString())
    }
  }

  @Nested
  @DisplayName("JsonBoolean#toPrettyJsonString()")
  inner class ToPrettyJsonString {

    val expects = arrayOf("true", "false")

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.toJsonString())
    }
  }
}