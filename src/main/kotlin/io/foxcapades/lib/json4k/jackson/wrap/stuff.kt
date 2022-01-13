@file:Suppress("NOTHING_TO_INLINE")

package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.*
import java.math.BigDecimal
import java.math.BigInteger

internal typealias Bool = Boolean
internal typealias BigDec = BigDecimal
internal typealias BigInt = BigInteger


internal const val MinUnsigned = 0
internal const val MaxUByte    = 255
internal const val MaxUShort   = 65_535
internal const val MaxUInt     = 4_294_967_295L
internal val       MaxULong    = BigInteger("18446744073709551615")


internal inline fun Boolean.toJson() =
  if (this) BooleanNode.TRUE else BooleanNode.FALSE

internal inline fun Byte.toJson() = ShortNode(this.toShort())
internal inline fun UByte.toJson() = ShortNode(this.toShort())
internal inline fun Short.toJson() = ShortNode(this)
internal inline fun UShort.toJson() = IntNode(this.toInt())
internal inline fun Int.toJson() = IntNode(this)
internal inline fun UInt.toJson() = LongNode(this.toLong())
internal inline fun Long.toJson() = LongNode(this)
internal inline fun ULong.toJson() = BigIntegerNode(BigInt(this.toString()))
internal inline fun BigInt.toJson() = BigIntegerNode(this)
internal inline fun Float.toJson() = FloatNode(this)
internal inline fun Double.toJson() = DoubleNode(this)
internal inline fun BigDec.toJson() = DecimalNode(this)
internal inline fun String.toJson() = TextNode(this)
