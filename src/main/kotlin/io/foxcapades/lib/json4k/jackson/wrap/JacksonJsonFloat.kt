package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.FloatNode
import java.math.BigDecimal

internal class JacksonJsonFloat(raw: FloatNode) : JsonNumber<FloatNode>(raw) {
  override fun bigDecValue(): BigDecimal = raw.decimalValue()
  override fun doubleValue(): Double = raw.doubleValue()
  override fun floatValue(): Float = raw.floatValue()
}