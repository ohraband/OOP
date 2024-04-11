package Image

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Pixel.Pixel
import TableConversion.DefaultTable
import org.scalatest.FunSuite
import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatest.MustMatchers.a

import scala.language.postfixOps

class ImageTest extends FunSuite {


  val testimage1 = new Image ( new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
    Array(new Pixel(3), new Pixel(4)))   )  ) // [[1,2],[3,4]]

  val testimage2 = new Image ( new GreyscalePixelGrid( Array[Array[Pixel]]() ) )

  test("testGetAllPixels") {
    for(x <- 0 until testimage1.GetX() ){
      for(y <- 0 until testimage1.GetY() ){
        testimage1.GetPixel(x,y) shouldBe a [Pixel]
      }
    }
  }

  test("testGetPixelOutOfBounds") {
    assertThrows[IllegalArgumentException](testimage1.GetPixel(2,2))
  }


  test("testGetAllPixelValues") {
    var counter = 1
    for(x <- 0 until testimage1.GetX() ){
      for(y <- 0 until testimage1.GetY() ){
        assert( testimage1.GetPixelValue(x,y) == counter )
        counter+=1
      }
    }
  }

  test("testGetPixelValueOutOfBounds") {
    assertThrows[IllegalArgumentException](testimage1.GetPixelValue(2,2))
  }


  test("testGetX") {
    assert( testimage1.GetX() == 2 )
  }

  test("testGetY") {
    assert( testimage1.GetY() == 2 )
  }

  test("testHeightWidthEmpty") {
    assert( testimage2.GetX() == 0 )
    assert( testimage2.GetY() == 0 )
  }

  test("testIsEmptyNonEmpty") {
    assert(!testimage1.isEmpty)
  }

  test("testIsEmptyEmpty") {
    assert(testimage2.isEmpty)
  }


  test("testMakeStringImage") {
      val stringimage = testimage1.makeStringImage(new DefaultTable)
      println(stringimage.GetString())
      assert(stringimage.GetString() contains "WW")
  }

  test("testMakeStringImageEmpty") {
    val stringimage = testimage2.makeStringImage(new DefaultTable)
    println(stringimage.GetString())
    assert(stringimage.GetString().isEmpty)
  }

}
