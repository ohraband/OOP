package Filter

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel
import org.scalatest.FunSuite

class InvertTest extends FunSuite {

  val testimage1 = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
    Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]

  val testimage2 = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(254), new Pixel(253)),
    Array(new Pixel(252), new Pixel(251)))     )  )

  test("testInvertlow") {
    val invert = new Invert
    val newimage = invert.apply(testimage1)

    assert( newimage.GetPixelValue(0,0) == 254 )
    assert( newimage.GetPixelValue(0,1) == 253 )
    assert( newimage.GetPixelValue(1,0) == 252 )
    assert( newimage.GetPixelValue(1,1) == 251 )
  }

  test("testInverthigh") {
    val invert = new Invert
    val newimage = invert.apply(testimage2)

    assert( newimage.GetPixelValue(0,0) == 1 )
    assert( newimage.GetPixelValue(0,1) == 2 )
    assert( newimage.GetPixelValue(1,0) == 3 )
    assert( newimage.GetPixelValue(1,1) == 4 )
  }

}
