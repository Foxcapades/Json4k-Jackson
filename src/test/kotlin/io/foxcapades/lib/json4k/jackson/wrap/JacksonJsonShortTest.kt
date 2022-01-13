package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.IntNode
import com.fasterxml.jackson.databind.node.ShortNode
import io.foxcapades.lib.json4k.JsonElementContractTest
import io.foxcapades.lib.json4k.JsonElementType
import io.foxcapades.lib.json4k.JsonNumeric.PrecisionLossException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigInteger
import kotlin.test.assertEquals

@DisplayName("JacksonJsonShort")
internal class JacksonJsonShortTest : JsonElementContractTest() {

  override val expectedType = JsonElementType.Integer

  override val targets = arrayOf(
    JacksonJsonShort(ShortNode(1)),
    JacksonJsonShort(ShortNode(2)),
    JacksonJsonShort(ShortNode(3)),
    JacksonJsonShort(ShortNode(4)),
    JacksonJsonShort(ShortNode(5)),
  )

  @Nested
  @DisplayName("#byteValue()")
  inner class ByteValue {

    val expects = arrayOf<Byte>(1, 2, 3, 4, 5)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.byteValue())
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is" +
      "greater than the max allowed value for a Byte")
    fun t2() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(128)).byteValue()
      }
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is less" +
      "than the min allowed value for a Byte")
    fun t3() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(-129)).byteValue()
      }
    }
  }

  @Nested
  @DisplayName("#UByteValue()")
  inner class UByteValue {

    val expects = arrayOf<UByte>(1u, 2u, 3u, 4u, 5u)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.uByteValue())
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is" +
      "greater than the max allowed value for a UByte")
    fun t2() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(256)).uByteValue()
      }
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is less" +
      "than the min allowed value for a UByte")
    fun t3() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(-1)).uByteValue()
      }
    }
  }

  @Nested
  @DisplayName("#shortValue()")
  inner class ShortValue {

    val expects = arrayOf<Short>(1, 2, 3, 4, 5)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.shortValue())
    }
  }

  @Nested
  @DisplayName("#UShortValue()")
  inner class UShortValue {

    val expects = arrayOf<UShort>(1u, 2u, 3u, 4u, 5u)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.uShortValue())
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is less" +
      "than the min allowed value for a UShort")
    fun t3() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(-1)).uShortValue()
      }
    }
  }

  @Nested
  @DisplayName("#intValue()")
  inner class IntValue {

    val expects = arrayOf(1, 2, 3, 4, 5)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.intValue())
    }
  }

  @Nested
  @DisplayName("#UIntValue()")
  inner class UIntValue {

    val expects = arrayOf(1u, 2u, 3u, 4u, 5u)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.uIntValue())
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is less" +
      "than the min allowed value for a UInt")
    fun t3() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(-1)).uIntValue()
      }
    }
  }

  @Nested
  @DisplayName("#longValue()")
  inner class LongValue {

    val expects = arrayOf<Long>(1, 2, 3, 4, 5)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.longValue())
    }
  }

  @Nested
  @DisplayName("#ULongValue()")
  inner class ULongValue {

    val expects = arrayOf<ULong>(1u, 2u, 3u, 4u, 5u)

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.uLongValue())
    }

    @Test
    @DisplayName("throws a PrecisionLossException if the wrapped value is less" +
      "than the min allowed value for a ULong")
    fun t3() {
      assertThrows<PrecisionLossException> {
        JacksonJsonShort(ShortNode(-1)).uLongValue()
      }
    }
  }

  @Nested
  @DisplayName("#bigIntValue()")
  inner class BigIntValue {

    val expects = arrayOf(
      BigInteger.valueOf(1),
      BigInteger.valueOf(2),
      BigInteger.valueOf(3),
      BigInteger.valueOf(4),
      BigInteger.valueOf(5),
    )

    @Test
    @DisplayName("returns the expected value")
    fun t1() = targets.forEachIndexed { i, it ->
      assertEquals(expects[i], it.bigIntValue())
    }
  }
}