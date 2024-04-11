package GreyscaleConverter

import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import org.scalatest.FunSuite

class RGBtoGreyscaleConverterTest extends FunSuite {

  test("testApplyEmpty") {
    val conv =  new RGBtoGreyscale
    val rgbgrid = new RGBpixelGrid(Array[Array[Pixel]]() )
    val greygrid = conv(new DefaultGreyscaleConverter, rgbgrid)
    assert(greygrid.isEmpty)
  }


  test("testApplyNormal") {
    val conv =  new RGBtoGreyscale
    val rgbgrid = new RGBpixelGrid( Array(Array(new Pixel(0x9A9A9A), new Pixel(0x9A9A9A), new Pixel(0x9A9A9A)),
      Array(new Pixel(0x9A9A9A), new Pixel(0x9A9A9A), new Pixel(0x9A9A9A)  ) ) )
    val greygrid = conv(new DefaultGreyscaleConverter, rgbgrid)

    for (x <- 0 until greygrid.Width()) {
      for (y <- 0 until greygrid.Height()){
        assert ( greygrid.GetPixelValue(x,y) == 154 )
      }
    }

  }


}
