package Pixel

import org.scalatest.FunSuite

class PixelTest extends FunSuite {
  val pixel = new Pixel(42)
  test("testGetValue") {
    assert(pixel.getValue == 42 )
  }
}
