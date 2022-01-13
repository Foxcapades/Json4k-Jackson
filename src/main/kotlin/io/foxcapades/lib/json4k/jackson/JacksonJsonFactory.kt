package io.foxcapades.lib.json4k.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import io.foxcapades.lib.json4k.*
import io.foxcapades.lib.json4k.JsonNumber
import io.foxcapades.lib.json4k.jackson.wrap.*
import java.math.BigDecimal
import java.math.BigInteger

class JacksonJsonFactory : JsonFactory {
  val mapper = ObjectMapper()

  override fun newArray(initialSize: Int): JsonArray =
    JacksonJsonArray(ArrayNode(mapper.nodeFactory, initialSize))

  override fun newBool(value: Boolean): JsonBoolean =
    JacksonJsonBoolean(value.toJson())

  override fun newInt(value: BigInteger): JsonInteger =
    JacksonJsonBigInt(value.toJson())

  override fun newInt(value: Byte): JsonInteger =
    JacksonJsonShort(value.toJson())

  override fun newInt(value: Int): JsonInteger =
    JacksonJsonInt(value.toJson())

  override fun newInt(value: Long): JsonInteger =
    JacksonJsonLong(value.toJson())

  override fun newInt(value: Short): JsonInteger =
    JacksonJsonShort(value.toJson())

  override fun newInt(value: UByte): JsonInteger =
    JacksonJsonShort(value.toJson())

  override fun newInt(value: UInt): JsonInteger =
    JacksonJsonLong(value.toJson())

  override fun newInt(value: ULong): JsonInteger =
    JacksonJsonBigInt(value.toJson())

  override fun newInt(value: UShort): JsonInteger =
    JacksonJsonInt(value.toJson())

  override fun newNull(): JsonNull = JacksonJsonNull()

  override fun newNumber(value: BigDecimal): JsonNumber =
    JacksonJsonBigDec(value.toJson())

  override fun newNumber(value: Double): JsonNumber =
    JacksonJsonDouble(value.toJson())

  override fun newNumber(value: Float): JsonNumber =
    JacksonJsonFloat(value.toJson())

  override fun newObject(initialSize: Int): JsonObject =
    JacksonJsonObject(ObjectNode(mapper.nodeFactory))

  override fun newString(value: String): JsonString =
    JacksonJsonString(value.toJson())
}