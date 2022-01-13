package io.foxcapades.lib.json4k.jackson.wrap

import com.fasterxml.jackson.databind.node.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("stuff.kt")
internal class StuffKtTest {

  @Nested
  @DisplayName("Boolean.toJson()")
  inner class Bool2Json {

    @Test
    @DisplayName("when true")
    fun test1() = assertEquals(BooleanNode.TRUE, true.toJson())

    @Test
    @DisplayName("when false")
    fun test2() = assertEquals(BooleanNode.FALSE, false.toJson())

  }

  @Nested
  @DisplayName("Byte.toJson()")
  inner class Byte2Json {

    @Test
    @DisplayName("wraps the value in a ShortNode")
    fun test1() = with(3.toByte().toJson()) {
      assertSame(ShortNode::class.java, this.javaClass)
      assertEquals(3, shortValue())
    }
  }

  @Nested
  @DisplayName("UByte.toJson()")
  inner class UByte2Json {

    @Test
    @DisplayName("wraps the value in a ShortNode")
    fun test1() = with(3.toUByte().toJson()) {
      assertSame(ShortNode::class.java, this.javaClass)
      assertEquals(3, shortValue())
    }
  }


  @Nested
  @DisplayName("Short.toJson()")
  inner class Short2Json {

    @Test
    @DisplayName("wraps the value in a ShortNode")
    fun test1() = with(3.toShort().toJson()) {
      assertSame(ShortNode::class.java, this.javaClass)
      assertEquals(3, shortValue())
    }
  }

  @Nested
  @DisplayName("UShort.toJson()")
  inner class UShort2Json {

    @Test
    @DisplayName("wraps the value in a IntNode")
    fun test1() = with(3.toUShort().toJson()) {
      assertSame(IntNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("Int.toJson()")
  inner class Int2Json {

    @Test
    @DisplayName("wraps the value in a IntNode")
    fun test1() = with(3.toJson()) {
      assertSame(IntNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("UInt.toJson()")
  inner class UInt2Json {

    @Test
    @DisplayName("wraps the value in a LongNode")
    fun test1() = with(3.toUInt().toJson()) {
      assertSame(LongNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("Long.toJson()")
  inner class Long2Json {

    @Test
    @DisplayName("wraps the value in a LongNode")
    fun test1() = with(3.toLong().toJson()) {
      assertSame(LongNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("ULong.toJson()")
  inner class ULong2Json {

    @Test
    @DisplayName("wraps the value in a BigIntegerNode")
    fun test1() = with(3.toULong().toJson()) {
      assertSame(BigIntegerNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("BigInteger.toJson()")
  inner class BigInteger2Json {

    @Test
    @DisplayName("wraps the value in a BigIntegerNode")
    fun test1() = with(3.toBigInteger().toJson()) {
      assertSame(BigIntegerNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("Float.toJson()")
  inner class Float2Json {

    @Test
    @DisplayName("wraps the value in a FloatNode")
    fun test1() = with(3.toFloat().toJson()) {
      assertSame(FloatNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("Double.toJson()")
  inner class Double2Json {

    @Test
    @DisplayName("wraps the value in a DoubleNode")
    fun test1() = with(3.toDouble().toJson()) {
      assertSame(DoubleNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("BigDecimal.toJson()")
  inner class BigDecimal2Json {

    @Test
    @DisplayName("wraps the value in a DecimalNode")
    fun test1() = with(3.toBigDecimal().toJson()) {
      assertSame(DecimalNode::class.java, this.javaClass)
      assertEquals(3, intValue())
    }
  }

  @Nested
  @DisplayName("String.toJson()")
  inner class String2Json {

    @Test
    @DisplayName("wraps the value in a TextNode")
    fun test1() = with("3".toJson()) {
      assertSame(TextNode::class.java, this.javaClass)
      assertEquals("3", textValue())
    }
  }
}
