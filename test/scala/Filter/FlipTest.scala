package Filter

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel
import org.scalatest.FunSuite

class FlipTest extends FunSuite {

  val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
    Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]

  test("testFlipX") {
    val flip = new Flip("x")
    val newimage = flip.apply(testimage)

    assert( newimage.GetPixelValue(0,0) == 2 )
    assert( newimage.GetPixelValue(0,1) == 1 )
    assert( newimage.GetPixelValue(1,0) == 4 )
    assert( newimage.GetPixelValue(1,1) == 3 )
  }

  test("testFlipY") {
    val flip = new Flip("y")
    val newimage = flip.apply(testimage)

    assert( newimage.GetPixelValue(0,0) == 3 )
    assert( newimage.GetPixelValue(0,1) == 4 )
    assert( newimage.GetPixelValue(1,0) == 1 )
    assert( newimage.GetPixelValue(1,1) == 2 )
  }


  test("testFlipXY") {
    val flip1 = new Flip("x")
    val flip2 = new Flip("y")
    val newimage = flip1.apply(testimage)
    val newimage2 = flip2.apply(newimage)

    assert( newimage2.GetPixelValue(0,0) == 4 )
    assert( newimage2.GetPixelValue(0,1) == 3 )
    assert( newimage2.GetPixelValue(1,0) == 2 )
    assert( newimage2.GetPixelValue(1,1) == 1 )
  }

  test("testFlipXX") {
    val flip1 = new Flip("x")
    val flip2 = new Flip("x")
    val newimage = flip1.apply(testimage)
    val newimage2 = flip2.apply(newimage)

    assert( newimage2.GetPixelValue(0,0) == 1 )
    assert( newimage2.GetPixelValue(0,1) == 2 )
    assert( newimage2.GetPixelValue(1,0) == 3 )
    assert( newimage2.GetPixelValue(1,1) == 4 )
  }

  test("testApply") {
    assertThrows[IllegalArgumentException](new Flip("wronginput").apply(testimage))
  }

}
