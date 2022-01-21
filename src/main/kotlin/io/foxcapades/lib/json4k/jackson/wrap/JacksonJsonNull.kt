package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.NullNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonNull

object JacksonJsonNull : JsonBase<NullNode>(NullNode.instance), JsonNull {
  override val type = JsonElementType.Null

  override fun ifNull(action: JsonNull.() -> Unit) {
    action(this)
  }
}