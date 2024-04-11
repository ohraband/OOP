package GreyscaletoASCII

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel
import TableConversion.DefaultTable
import org.scalatest.FunSuite

class GreyscaletoASCIITest extends FunSuite {


  val GreyscaletoASCII = new GreyscaletoASCII
  test("testMakeASCIIempty") {
    val res = GreyscaletoASCII.makeASCII(new Image(new GreyscalePixelGrid( Array[Array[Pixel]]() ) ), new DefaultTable )
    assert(res.isEmpty)
  }

  test("testMakeASCII") {
    val res = GreyscaletoASCII.makeASCII(new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(1), new Pixel(1)),
      Array(new Pixel(1), new Pixel(1), new Pixel(1)))     )  ), new DefaultTable )
    assert(res contains "WW")
  }
}
