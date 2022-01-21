package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.FloatNode
import java.math.BigDecimal
import kotlin.math.round

internal class JacksonJsonFloat(raw: FloatNode) : JsonNumber<FloatNode>(raw) {
  override val isIntegral: Boolean
    get() = raw.floatValue() == round(raw.floatValue())

  override fun bigDecValue(): BigDecimal = raw.decimalValue()

  override fun doubleValue(): Double = raw.doubleValue()

  override fun floatValue(): Float = raw.floatValue()
}