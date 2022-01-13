@file:Suppress("NOTHING_TO_INLINE")

package io.foxcapades.lib.json4k.jackson

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.*
import io.foxcapades.lib.json4k.JsonElement
import io.foxcapades.lib.json4k.jackson.wrap.*
import io.foxcapades.lib.json4k.jackson.wrap.JacksonJsonBigInt
import io.foxcapades.lib.json4k.jackson.wrap.JacksonJsonInt
import io.foxcapades.lib.json4k.jackson.wrap.JacksonJsonLong
import io.foxcapades.lib.json4k.jackson.wrap.JacksonJsonShort

internal inline fun act(action: () -> Any) {
  action()
}

internal inline fun Char.isHex(): Boolean =
  when (this) {
    in '0'..'9' -> true
    in 'A'..'F' -> true
    in 'a'..'f' -> true
    else        -> false
  }

@Suppress("UNCHECKED_CAST")
internal inline fun elementToNode(js: JsonElement): JsonNode =
  (js as JsonBase<*>).raw

internal inline fun nodeToElement(js: JsonNode) =
  when (js) {
    is ContainerNode<*> -> when (js) {
      is ArrayNode  -> JacksonJsonArray(js)
      is ObjectNode -> JacksonJsonObject(js)
      else          -> throw IllegalStateException()
    }
    is NumericNode      -> when (js) {
      is BigIntegerNode -> JacksonJsonBigInt(js)
      is DecimalNode    -> JacksonJsonBigDec(js)
      is DoubleNode     -> JacksonJsonDouble(js)
      is FloatNode      -> JacksonJsonFloat(js)
      is IntNode        -> JacksonJsonInt(js)
      is LongNode       -> JacksonJsonLong(js)
      is ShortNode      -> JacksonJsonShort(js)
      else              -> throw IllegalStateException()
    }
    is BinaryNode       -> TODO()
    is BooleanNode      -> TODO()
    is NullNode         -> TODO()
    is TextNode         -> TODO()
    else                -> throw IllegalArgumentException()
  }