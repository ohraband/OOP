package Loader

import PixelGrid.RGBpixelGrid.RGBpixelGrid
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class GifLoaderTest extends FunSuite {

  test("testLoadImage") {
    val gifLoader = new GifLoader("Season4gif.gif")
    val rgbgrid = gifLoader.LoadImage()
    rgbgrid shouldBe a [RGBpixelGrid]
  }

  test("Wrong input") {
    val gifLoader = new GifLoader("Season4png.png")
    assertThrows[IllegalArgumentException](gifLoader.LoadImage())
  }


  test("Very wrong input") {
    val gifLoader = new GifLoader("jklhsfkjhgif")
    assertThrows[IllegalArgumentException](gifLoader.LoadImage())
  }

}
