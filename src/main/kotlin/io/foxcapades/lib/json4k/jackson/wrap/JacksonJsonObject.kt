package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.NullNode
import com.fasterxml.jackson.databind.node.ObjectNode
import io.foxcapades.lib.json4k.JsonElement
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonObject
import io.foxcapades.lib.json4k.jackson.elementToNode
import io.foxcapades.lib.json4k.jackson.nodeToElement
import java.util.*
import java.util.stream.StreamSupport

internal class JacksonJsonObject(raw: ObjectNode)
  : JsonBase<ObjectNode>(raw), JsonObject
{
  override val type = JsonElementType.Object

  override val size = raw.size()

  override fun contains(key: String) = raw.get(key) != null

  override fun get(key: String): JsonElement? =
    raw.get(key)?.let(::nodeToElement)

  override fun set(key: String, value: Bool) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: Byte) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: UByte) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: Short) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: UShort) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: Int) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: UInt) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: Long) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: ULong) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: BigInt) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: Float) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: Double) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: BigDec) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: String) =
    also { raw.set<ObjectNode>(key, value.toJson()) }

  override fun set(key: String, value: JsonElement) =
    also { raw.set<ObjectNode>(key, elementToNode(value)) }

  override fun setNull(key: String) =
    also { raw.set<ObjectNode>(key, NullNode.instance) }

  override fun setBoolIf(condition: Bool, key: String, action: () -> Bool) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setByteIf(condition: Bool, key: String, action: () -> Byte) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setUByteIf(condition: Bool, key: String, action: () -> UByte) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setShortIf(condition: Bool, key: String, action: () -> Short) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setUShortIf(condition: Bool, key: String,action: () -> UShort) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setIntIf(condition: Bool, key: String, action: () -> Int) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setLongIf(condition: Bool, key: String, action: () -> Long) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setULongIf(condition: Bool, key: String, action: () -> ULong) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setBigIntIf(condition: Bool, key: String, action: () -> BigInt) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setFloatIf(condition: Bool, key: String, action: () -> Float) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setDoubleIf(condition: Bool, key: String, action: () -> Double) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setBigDecIf(condition: Bool, key: String, action: () -> BigDec) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setStringIf(condition: Bool, key: String, action: () -> String) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun setElementIf(
    condition: Bool,
    key: String,
    action: () -> JsonElement,
  ) = also { if (condition) raw.set<ObjectNode>(key, elementToNode(action())) }

  override fun setIf(condition: Bool, key: String, value: BigInt) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Bool) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Byte) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: UByte) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Short) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: UShort) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Int) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: UInt) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Long) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: ULong) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Float) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: Double) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: BigDec) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: String) =
    also { if (condition) raw.set<ObjectNode>(key, value.toJson()) }

  override fun setIf(condition: Bool, key: String, value: JsonElement) =
    also { if (condition) raw.set<ObjectNode>(key, elementToNode(value)) }

  override fun setNullIf(condition: Bool, key: String) =
    also { if (condition) raw.set<ObjectNode>(key, NullNode.instance) }

  override fun setUIntIf(condition: Bool, key: String, action: () -> UInt) =
    also { if (condition) raw.set<ObjectNode>(key, action().toJson()) }

  override fun with(action: JsonObject.() -> Unit) = action()

  override fun withIf(condition: Bool, action: JsonObject.() -> Unit) =
    if (condition) action() else Unit

  override fun iterator(): Iterator<Pair<String, JsonElement>> {
    return StreamSupport.stream(
      Spliterators.spliteratorUnknownSize(raw.fields(), Spliterator.DISTINCT),
      false
    ).map { it.key to nodeToElement(it.value) as JsonElement }.iterator()
  }
}