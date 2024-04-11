package PixelGrid.RGBpixelGrid

import Pixel.Pixel
import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatest.MustMatchers.a

class RGBpixelGridTest extends FunSuite {


  val testgrid1 = new RGBpixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
    Array(new Pixel(3), new Pixel(4)))   )  // [[1,2],[3,4]]

  val testgrid2 = new RGBpixelGrid( Array[Array[Pixel]]() )


  test("testGetAllPixels") {
    for(x <- 0 until testgrid1.Width() ){
      for(y <- 0 until testgrid1.Height() ){
        testgrid1.GetPixel(x,y) shouldBe a [Pixel]
      }
    }
  }

  test("testGetPixelOutOfBounds") {
    assertThrows[IllegalArgumentException](testgrid1.GetPixel(2,2))
  }

  test("testGetAllPixelValues") {
    var counter = 1
    for(x <- 0 until testgrid1.Width() ){
      for(y <- 0 until testgrid1.Height() ){
        assert( testgrid1.GetPixelValue(x,y) == counter )
        counter+=1
      }
    }
  }

  test("testGetPixelValueOutOfBounds") {
    assertThrows[IllegalArgumentException](testgrid1.GetPixelValue(2,2))
  }

  test("testHeight") {
    assert( testgrid1.Height() == 2 )
  }

  test("testWidth") {
    assert( testgrid1.Width() == 2 )
  }

  test("testHeightWidthEmpty") {
    assert( testgrid2.Height() == 0 )
    assert( testgrid2.Width() == 0 )
  }

  test("testIsEmptyNonEmpty") {
    assert(!testgrid1.isEmpty)
  }

  test("testIsEmptyEmpty") {
    assert(testgrid2.isEmpty)
  }

}
