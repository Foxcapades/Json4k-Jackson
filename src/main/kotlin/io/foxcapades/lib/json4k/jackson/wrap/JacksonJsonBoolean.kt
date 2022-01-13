package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.BooleanNode
import io.foxcapades.lib.json4k.JsonBoolean
import io.foxcapades.lib.json4k.JsonElementType

internal class JacksonJsonBoolean(raw: BooleanNode)
  : JsonBase<BooleanNode>(raw), JsonBoolean
{
  override val type = JsonElementType.Boolean

  override fun booleanValue() = raw.booleanValue()
}