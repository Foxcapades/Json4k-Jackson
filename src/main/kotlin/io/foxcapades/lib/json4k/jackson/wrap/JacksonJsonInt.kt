package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.IntNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonInteger
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import java.math.BigInteger

internal class JacksonJsonInt(raw: IntNode)
  : JsonInt<IntNode>(raw), JsonInteger
{
  override val isIntegral = true
  
  override val type = JsonElementType.Integer

  override fun bigIntValue(): BigInteger = BigInteger.valueOf(raw.longValue())

  override fun byteValue(): Byte =
    with(raw.intValue()) {
      if (this > Byte.MAX_VALUE || this < Byte.MIN_VALUE)
        throw PrecisionLossException("Cannot cast a value of $this to Byte.")
      toByte()
    }

  override fun intValue(): Int = raw.intValue()

  override fun longValue(): Long = raw.longValue()

  override fun shortValue(): Short =
    with(raw.intValue()) {
      if (this > Short.MAX_VALUE || this < Short.MIN_VALUE)
        throw PrecisionLossException("Cannot cast a value of $this to Short.")
      toShort()
    }

  override fun uByteValue(): UByte =
    with(raw.intValue()) {
      if (this > MaxUByte || this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UByte.")
      toUByte()
    }

  override fun uIntValue(): UInt =
    with(raw.intValue()) {
      if (this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      return toUInt()
    }

  override fun uLongValue(): ULong =
    with(raw.intValue()) {
      if (this < MinUnsigned)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      return toULong()
    }

  override fun uShortValue(): UShort =
    with(raw.intValue()) {
      if (this < MinUnsigned || this > MaxUShort)
        throw PrecisionLossException("Cannot cast a value of $this to UShort.")
      return toUShort()
    }
}