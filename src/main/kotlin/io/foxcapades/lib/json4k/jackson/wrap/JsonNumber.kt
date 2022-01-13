package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.NumericNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonInteger
import io.foxcapades.lib.json4k.JsonNumber
import io.foxcapades.lib.json4k.JsonNumeric

internal sealed class JsonNumber<T : NumericNode>(raw: T)
  : JsonBase<T>(raw), JsonNumber
{
  override val type = JsonElementType.Number

  override fun compareTo(other: JsonNumeric): Int {
    return when (other) {
      is JsonInteger -> raw.decimalValue().compareTo(other.bigIntValue().toBigDecimal())
      is JsonNumber  -> raw.decimalValue().compareTo(other.bigDecValue())
      else           -> throw IllegalArgumentException()
    }
  }
}