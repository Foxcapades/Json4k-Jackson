package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.ShortNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonInteger
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import java.math.BigInteger

internal class JacksonJsonShort(raw: ShortNode)
  : JsonInt<ShortNode>(raw), JsonInteger
{
  override val type = JsonElementType.Integer

  override fun bigIntValue(): BigInteger = raw.bigIntegerValue()

  override fun byteValue() =
    with(raw.shortValue()) {
      if (this > Byte.MAX_VALUE || this < Byte.MIN_VALUE)
        throw PrecisionLossException("Cannot cast a value of $this to Byte.")
      this.toByte()
    }

  override fun shortValue() = raw.shortValue()

  override fun intValue() = raw.intValue()

  override fun longValue() = raw.longValue()

  override fun uByteValue() =
    with(raw.shortValue()) {
      if (this > MaxUByte || this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UByte.")
      this.toUByte()
    }

  override fun uShortValue() =
    with(raw.shortValue()) {
      if (this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UShort.")
      this.toUShort()
    }

  override fun uIntValue() =
    with(raw.shortValue()) {
      if (this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      this.toUInt()
    }

  override fun uLongValue() =
    with(raw.shortValue()) {
      if (this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to ULong.")
      this.toULong()
    }
}
