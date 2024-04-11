package GreyscaleConverter

import Pixel.Pixel
import org.scalatest.FunSuite

class DesturationGreyscaleConverterTest extends FunSuite {

  val conv = new DesturationGreyscaleConverter

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
    val pixel = new Pixel(0x9A0012) // (154 + 0) / 2 = 77
    val newpixel = conv(pixel)
    assert(77 equals newpixel.getValue)
  }

  test("testOutOfBounds") {
    val pixel1 = new Pixel(0xFFFFFFFF)
    val newpixel1 = conv(pixel1)
    assert(255 equals newpixel1.getValue)
  }

}
