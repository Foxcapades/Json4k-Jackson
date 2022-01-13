package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.JsonNode
import io.foxcapades.lib.json4k.JsonElement

sealed class JsonBase<T : JsonNode>(val raw: T) : JsonElement {
  override fun toJsonString(): String = raw.toString()

  override fun toPrettyJsonString(): String = raw.toPrettyString()

  override fun equals(other: Any?) =
    if (other !is JsonBase<*>) false else raw == other.raw

  override fun hashCode(): Int = raw.hashCode()

  override fun toString(): String = raw.toPrettyString()
}
