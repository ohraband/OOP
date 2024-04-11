package GreyscaleConverter

import Pixel.Pixel
import org.scalatest.FunSuite

class DefaultGreyscaleConverterTest extends FunSuite {

  val conv = new DefaultGreyscaleConverter

  test("testMin") {
    val pixel = new Pixel(0)
    val newpixel = conv(pixel)
    assert(0 equals newpixel.getValue)
  }

  test("testMax") {
    val pixel = new Pixel(0xFFFFFF)
    val newpixel = conv(pixel)
    assert(255 equals newpixel.getValue)
  }

  test("testValue") {
    val pixel = new Pixel(0x9A9A9A)
    val newpixel = conv(pixel)
    assert(154 equals newpixel.getValue)
  }

  test("testOutOfBounds") {
    val pixel1 = new Pixel(0xFFFFFFFF)
    val newpixel1 = conv(pixel1)
    assert(255 equals newpixel1.getValue)
  }

}
