package io.foxcapades.lib.json4k.jackson

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.*
import io.foxcapades.lib.json4k.*
import io.foxcapades.lib.json4k.JsonNumber
import io.foxcapades.lib.json4k.jackson.wrap.*
import java.io.InputStream
import java.io.Reader
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

  override fun newNull(): JsonNull = JacksonJsonNull

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

  override fun deserialize(stream: InputStream) =
    sortDeserialize(mapper.readTree(stream))

  override fun deserialize(reader: Reader) =
    sortDeserialize(mapper.readTree(reader))

  override fun deserialize(string: String) =
    sortDeserialize(mapper.readTree(string))

  private inline fun sortDeserialize(tmp: JsonNode): JsonElement {
    return when (tmp.nodeType) {
      JsonNodeType.ARRAY   -> JacksonJsonArray(tmp as ArrayNode)
      JsonNodeType.BINARY  -> JacksonJsonBinary(tmp as BinaryNode)
      JsonNodeType.BOOLEAN -> JacksonJsonBoolean(tmp as BooleanNode)
      JsonNodeType.NULL    -> JacksonJsonNull
      JsonNodeType.NUMBER  -> when {
        tmp.isIntegralNumber -> JacksonJsonBigInt(BigIntegerNode(tmp.bigIntegerValue()))
        else                 -> JacksonJsonBigDec(DecimalNode(tmp.decimalValue()))
      }
      JsonNodeType.OBJECT  -> JacksonJsonObject(tmp as ObjectNode)
      JsonNodeType.STRING  -> JacksonJsonString(tmp as TextNode)
      else                 -> throw IllegalStateException()
    }
  }
}