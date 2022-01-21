package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.DecimalNode
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import java.math.BigDecimal

internal class JacksonJsonBigDec(raw: DecimalNode)
  : JsonNumber<DecimalNode>(raw)
{
  override val isIntegral by lazy {
    try {
      raw.decimalValue().toBigIntegerExact()
      true
    } catch (e: ArithmeticException) {
      false
    }
  }

  override fun bigDecValue(): BigDecimal = raw.decimalValue()

  override fun doubleValue() =
    raw.doubleValue().also {
      if (BigDecimal.valueOf(it) != raw.decimalValue())
        throw PrecisionLossException("Cannot cast a value of $it to Double.")
    }

  override fun floatValue() =
    raw.floatValue().also {
      if (BigDecimal.valueOf(it.toDouble()) != raw.decimalValue())
        throw PrecisionLossException("Cannot cast a value of $it to Float.")
    }
}