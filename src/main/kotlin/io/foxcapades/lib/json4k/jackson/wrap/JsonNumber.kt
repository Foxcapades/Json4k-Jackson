package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.NumericNode
import io.foxcapades.lib.json4k.*
import io.foxcapades.lib.json4k.JsonNumber

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

  override fun ifDecimal(action: JsonNumber.() -> Unit) {
    if (!isIntegral)
      action(this)
  }

  override fun ifIntegral(action: JsonInteger.() -> Unit) {
    if (!isIntegral)
      return

    if (this is JsonInteger)
      action(this)
    else
      action(Json.newInt(bigDecValue().toBigInteger()))
  }

  override fun ifNumeric(action: JsonNumeric.() -> Unit) {
    action(this)
  }
}