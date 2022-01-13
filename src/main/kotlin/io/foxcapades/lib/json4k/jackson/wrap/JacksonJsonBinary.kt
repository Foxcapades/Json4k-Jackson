package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.BinaryNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonString

internal class JacksonJsonBinary(raw: BinaryNode)
  : JsonBase<BinaryNode>(raw), JsonString
{
  override val type = JsonElementType.String

  override val isBlank = raw.textValue().isBlank()

  override val isEmpty = raw.textValue().isEmpty()

  override val isNotBlank = raw.textValue().isNotBlank()

  override val isNotEmpty = raw.textValue().isNotEmpty()

  override val length = raw.textValue().length

  override fun binaryValue(): ByteArray {
    try {
      return raw.binaryValue()
    } catch (e: Exception) {
      throw JsonString.NonBinaryStringException()
    }
  }

  override fun stringValue(): String = raw.textValue()
}