package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.NumericNode
import io.foxcapades.lib.json4k.JsonInteger
import io.foxcapades.lib.json4k.JsonNumber
import io.foxcapades.lib.json4k.JsonNumeric
import java.math.BigInteger

internal sealed class JsonInt<T : NumericNode>(raw: T)
  : JsonBase<T>(raw), JsonInteger
{
  override fun compareTo(other: JsonNumeric): Int {
    return when (other) {
      is JsonInteger -> raw.bigIntegerValue().compareTo(other.bigIntValue())
      is JsonNumber  -> raw.decimalValue().compareTo(other.bigDecValue())
      else           -> throw IllegalArgumentException()
    }
  }
}