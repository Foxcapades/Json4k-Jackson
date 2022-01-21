package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.LongNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonInteger
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import java.math.BigInteger

internal class JacksonJsonLong(raw: LongNode)
  : JsonInt<LongNode>(raw), JsonInteger
{
  override val isIntegral = true

  override val type = JsonElementType.Integer

  override fun bigIntValue(): BigInteger = raw.bigIntegerValue()

  override fun byteValue(): Byte =
    with(raw.longValue()) {
      if (this > 127 || this < -128)
        throw PrecisionLossException("Cannot cast a value of $this to Byte.")
      toByte()
    }

  override fun shortValue(): Short =
    with(raw.longValue()) {
      if (this > Short.MAX_VALUE || this < Short.MIN_VALUE)
        throw PrecisionLossException("Cannot cast a value of $this to Short.")
      toShort()
    }

  override fun intValue(): Int =
    with(raw.longValue()) {
      if (this > Integer.MAX_VALUE || this < Integer.MIN_VALUE)
        throw PrecisionLossException("Cannot cast a value of $this to Int.")
      toInt()
    }

  override fun longValue(): Long = raw.longValue()

  override fun uByteValue(): UByte =
    with(raw.longValue()) {
      if (this > MaxUByte || this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UByte.")
      toUByte()
    }

  override fun uShortValue(): UShort =
    with(raw.longValue()) {
      if (this < MinUnsigned || this > MaxUShort)
        throw PrecisionLossException("Cannot cast a value of $this to UShort.")
      return toUShort()
    }

  override fun uIntValue(): UInt =
    with(raw.longValue()) {
      if (this < MinUnsigned || this > MaxUInt)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      return toUInt()
    }

  override fun uLongValue(): ULong =
    with(raw.bigIntegerValue()) {
      if (this < BigInteger.ZERO || this > MaxULong)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      return toString().toULong()
    }
}