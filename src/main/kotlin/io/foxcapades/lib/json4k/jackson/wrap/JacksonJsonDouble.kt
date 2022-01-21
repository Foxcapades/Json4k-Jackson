package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.DoubleNode
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import java.math.BigDecimal
import kotlin.math.round

internal class JacksonJsonDouble(raw: DoubleNode)
  : JsonNumber<DoubleNode>(raw)
{
  override val isIntegral
    get() = raw.doubleValue() == round(raw.doubleValue())

  override fun bigDecValue(): BigDecimal = raw.decimalValue()

  override fun doubleValue(): Double = raw.doubleValue()

  override fun floatValue(): Float = raw.floatValue().also {
    if (it.toString() != raw.doubleValue().toString())
      throw PrecisionLossException("Cannot cast a value of $it to Float.")
  }
}