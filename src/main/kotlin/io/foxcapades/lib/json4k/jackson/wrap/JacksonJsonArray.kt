package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.*
import io.foxcapades.lib.json4k.JsonArray
import io.foxcapades.lib.json4k.JsonElement
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.jackson.act
import io.foxcapades.lib.json4k.jackson.elementToNode
import io.foxcapades.lib.json4k.jackson.nodeToElement
import java.math.BigInteger
import java.util.stream.StreamSupport

@Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
@OptIn(ExperimentalUnsignedTypes::class)
internal class JacksonJsonArray(raw: ArrayNode)
  : JsonBase<ArrayNode>(raw), JsonArray
{
  override val size: Int = raw.size()

  override val type = JsonElementType.Array

  override fun add(vararg values: Bool) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: Byte) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: UByte) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: Short) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: UShort) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: Int) = also { values.forEach { raw.add(it) } }

  override fun add(vararg values: UInt) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: Long) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: ULong) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: BigInt) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: Float) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: Double) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: BigDec) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun add(vararg values: JsonElement) =
    also { values.forEach { raw.add(elementToNode(it)) } }

  override fun add(vararg values: String) =
    also { values.forEach { raw.add(it.toJson()) } }

  override fun addNull() = also { raw.add(NullNode.instance) }

  // region addIf action

  override fun addBoolIf(condition: Bool, action: () -> Bool) =
    also { if (condition) raw.add(if (action()) BooleanNode.TRUE else BooleanNode.FALSE) }

  override fun addByteIf(condition: Bool, action: () -> Byte) =
    also { if (condition) raw.add(ShortNode(action().toShort())) }

  override fun addUByteIf(condition: Bool, action: () -> UByte) =
    also { if (condition) raw.add(ShortNode(action().toShort())) }

  override fun addShortIf(condition: Bool, action: () -> Short) =
    also { if (condition) raw.add(ShortNode(action())) }

  override fun addUShortIf(condition: Bool, action: () -> UShort) =
    also { if (condition) raw.add(IntNode(action().toInt())) }

  override fun addIntIf(condition: Bool, action: () -> Int) =
    also { if (condition) raw.add(IntNode(action())) }

  override fun addUIntIf(condition: Bool, action: () -> UInt) =
    also { if (condition) raw.add(LongNode(action().toLong())) }

  override fun addLongIf(condition: Bool, action: () -> Long) =
    also { if (condition) raw.add(LongNode(action())) }

  override fun addULongIf(condition: Bool, action: () -> ULong) =
    also { if (condition) raw.add(BigIntegerNode(BigInteger(action().toString()))) }

  override fun addBigIntIf(condition: Bool, action: () -> BigInt) =
    also { if (condition) raw.add(BigIntegerNode(action())) }

  override fun addFloatIf(condition: Bool, action: () -> Float) =
    also { if (condition) raw.add(FloatNode(action())) }

  override fun addDoubleIf(condition: Bool, action: () -> Double) =
    also { if (condition) raw.add(DoubleNode(action())) }

  override fun addBigDecIf(condition: Bool, action: () -> BigDec) =
    also { if (condition) raw.add(DecimalNode(action())) }

  override fun addElementIf(condition: Bool, action: () -> JsonElement) =
    also { if (condition) raw.add(elementToNode(action())) }

  override fun addStringIf(condition: Bool, action: () -> String) =
    also { if (condition) raw.add(TextNode(action())) }

  // endregion

  // region addIf static

  override fun addIf(condition: Bool, vararg values: Bool) =
    also { if (condition) values.forEach { raw.add(if (it) BooleanNode.TRUE else BooleanNode.FALSE) } }

  override fun addIf(condition: Bool, vararg values: Byte) =
    also { if (condition) values.forEach { raw.add(ShortNode(it.toShort())) } }

  override fun addIf(condition: Bool, vararg values: UByte) =
    also { if (condition) values.forEach { raw.add(ShortNode(it.toShort())) } }

  override fun addIf(condition: Bool, vararg values: Short) =
    also { if (condition) values.forEach { raw.add(ShortNode(it)) } }

  override fun addIf(condition: Bool, vararg values: UShort) =
    also { values.forEach { raw.add(IntNode(it.toInt())) } }

  override fun addIf(condition: Bool, vararg values: Int) =
    also { if (condition) values.forEach { raw.add(IntNode(it)) } }

  override fun addIf(condition: Bool, vararg values: UInt) =
    also { if (condition) values.forEach { raw.add(LongNode(it.toLong())) } }

  override fun addIf(condition: Bool, vararg values: Long) =
    also { if (condition) values.forEach { raw.add(LongNode(it)) } }

  override fun addIf(condition: Bool, vararg values: ULong) =
    also { if (condition) values.forEach { raw.add(BigInt(it.toString())) } }

  override fun addIf(condition: Bool, vararg values: BigInt) =
    also { if (condition) values.forEach { raw.add(BigIntegerNode(it)) } }

  override fun addIf(condition: Bool, vararg values: Float) =
    also { if (condition) values.forEach { raw.add(FloatNode(it)) } }

  override fun addIf(condition: Bool, vararg values: Double) =
    also { if (condition) values.forEach { raw.add(DoubleNode(it)) } }

  override fun addIf(condition: Bool, vararg values: BigDec) =
    also { if (condition) values.forEach { raw.add(DecimalNode(it)) } }

  override fun addIf(condition: Bool, vararg values: String) =
    also { if (condition) values.forEach { raw.add(TextNode(it)) } }


  override fun addIf(condition: Bool, vararg values: JsonElement) =
    also { if (condition) values.forEach { raw.add(elementToNode(it)) } }

  override fun addNullIf(condition: Bool) =
    also { if (condition) raw.add(NullNode.instance) }


  // endregion

  // region contains

  override fun contains(value: Bool) = raw.contains(value.toJson())

  override fun contains(value: Byte) = raw.contains(value.toJson())

  override fun contains(value: UByte) = raw.contains(value.toJson())

  override fun contains(value: Short) = raw.contains(value.toJson())

  override fun contains(value: UShort) = raw.contains(value.toJson())

  override fun contains(value: Int) = raw.contains(value.toJson())

  override fun contains(value: UInt) = raw.contains(value.toJson())

  override fun contains(value: Long) = raw.contains(value.toJson())

  override fun contains(value: ULong) = raw.contains(value.toJson())

  override fun contains(value: BigInt) = raw.contains(value.toJson())

  override fun contains(value: Float) = raw.contains(value.toJson())

  override fun contains(value: Double) = raw.contains(value.toJson())

  override fun contains(value: BigDec) = raw.contains(value.toJson())

  override fun contains(value: String) = raw.contains(value.toJson())

  override fun contains(node: JsonElement) = raw.contains(elementToNode(node))

  override fun containsNull() = raw.find { it is NullNode } != null


  override fun get(index: Int) = nodeToElement(raw[index])

  override fun iterator(): Iterator<JsonElement> =
    StreamSupport.stream(raw.spliterator(), false)
      .map { nodeToElement(it) }
      .iterator()

  override fun set(index: Int, value: Byte) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: UByte) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: Short) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: UShort) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: Int) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: UInt) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: Long) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: ULong) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: BigInt) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: Float) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: Double) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: BigDec) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: Bool) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, value: String) =
    act { raw.set(index, value.toJson()) }

  override fun set(index: Int, node: JsonElement) =
    act { raw.set(index, elementToNode(node)) }

  override fun setNull(index: Int) = also { raw.set(index, NullNode.instance) }

  override fun with(action: JsonArray.() -> Unit) = this.action()

  override fun withIf(condition: Bool, action: JsonArray.() -> Unit) =
    if (condition) this.action() else Unit

}