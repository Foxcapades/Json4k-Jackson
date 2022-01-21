package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.BigIntegerNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonInteger
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import java.math.BigInteger

internal class JacksonJsonBigInt(raw: BigIntegerNode)
  : JsonInt<BigIntegerNode>(raw), JsonInteger
{
  companion object {
    val MaxByte: BigInteger get() = BigInteger.valueOf(127)
    val MinByte: BigInteger get() = BigInteger.valueOf(-128)
    val MaxShort: BigInteger get() = BigInteger.valueOf(32_767)
    val MinShort: BigInteger get() = BigInteger.valueOf(-32_768)
    val MaxInt: BigInteger get() = BigInteger.valueOf(2_147_483_647)
    val MinInt: BigInteger get() = BigInteger.valueOf(-2_147_483_648)
    val MaxLong: BigInteger get() = BigInteger.valueOf(Long.MAX_VALUE)
    val MinLong: BigInteger get() = BigInteger.valueOf(Long.MIN_VALUE)
    val MaxUByte: BigInteger get() = BigInteger.valueOf(255)
    val MaxUShort: BigInteger get() = BigInteger.valueOf(65_535)
    val MaxUInt: BigInteger get() = BigInteger.valueOf(4_294_967_295L)
    val MaxULong: BigInteger get() = BigInteger("18446744073709551615")
  }

  override val isIntegral = true

  override val type = JsonElementType.Integer

  override fun bigIntValue(): BigInteger = raw.bigIntegerValue()

  override fun byteValue(): Byte =
    with(raw.bigIntegerValue()) {
      if (this > MaxByte || this < MinByte)
        throw PrecisionLossException("Cannot cast a value of $this to Byte.")
      toByte()
    }

  override fun shortValue(): Short =
    with(raw.bigIntegerValue()) {
      if (this > MaxShort || this < MinShort)
        throw PrecisionLossException("Cannot cast a value of $this to Short.")
      toShort()
    }

  override fun intValue(): Int =
    with(raw.bigIntegerValue()) {
      if (this > MaxInt || this < MinInt)
        throw PrecisionLossException("Cannot cast a value of $this to Int.")
      toInt()
    }

  override fun longValue(): Long =
    with(raw.bigIntegerValue()) {
      if (this > MaxLong || this < MinLong)
        throw PrecisionLossException("Cannot cast a value of $this to Long.")
      toLong()
    }

  override fun uByteValue(): UByte =
    with(raw.bigIntegerValue()) {
      if (this > MaxUByte || this < BigInteger.ZERO)
        throw PrecisionLossException("Cannot cast a value of $this to UByte.")
      toShort().toUByte()
    }

  override fun uShortValue(): UShort =
    with(raw.bigIntegerValue()) {
      if (this < BigInteger.ZERO || this > MaxUShort)
        throw PrecisionLossException("Cannot cast a value of $this to UShort.")
      return toInt().toUShort()
    }

  override fun uIntValue(): UInt =
    with(raw.bigIntegerValue()) {
      if (this < BigInteger.ZERO || this > MaxUInt)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      return toLong().toUInt()
    }

  override fun uLongValue(): ULong =
    with(raw.bigIntegerValue()) {
      if (this < BigInteger.ZERO || this > MaxULong)
        throw PrecisionLossException("Cannot cast a value of $this to UInt.")
      return toString().toULong()
    }
}