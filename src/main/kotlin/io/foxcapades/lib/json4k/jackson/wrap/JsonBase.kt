package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.JsonNode
import io.foxcapades.lib.json4k.*
import io.foxcapades.lib.json4k.JsonNumber

sealed class JsonBase<T : JsonNode>(val raw: T) : JsonElement {
  override fun toJsonString(): String = raw.toString()

  override fun toPrettyJsonString(): String = raw.toPrettyString()

  override fun equals(other: Any?) =
    if (other !is JsonBase<*>) false else raw == other.raw

  override fun hashCode(): Int = raw.hashCode()

  override fun toString(): String = raw.toPrettyString()

  override fun ifArray(action: JsonArray.() -> Unit) {}

  override fun ifBoolean(action: JsonBoolean.() -> Unit) {}

  override fun ifDecimal(action: JsonNumber.() -> Unit) {}

  override fun ifIntegral(action: JsonInteger.() -> Unit) {}

  override fun ifNull(action: JsonNull.() -> Unit) {}

  override fun ifNumeric(action: JsonNumeric.() -> Unit) {}

  override fun ifObject(action: JsonObject.() -> Unit) {}

  override fun ifString(action: JsonString.() -> Unit) {}
}
