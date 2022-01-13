package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.NullNode
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonNull

class JacksonJsonNull() : JsonBase<NullNode>(NullNode.instance), JsonNull {
  override val type = JsonElementType.Null
}