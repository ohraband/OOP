package Loader

import PixelGrid.RGBpixelGrid.RGBpixelGrid
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class PngLoaderTest extends FunSuite {

  test("testLoadImage") {
    val pngLoader = new PngLoader("Season4png.png")
    val rgbgrid = pngLoader.LoadImage()
    rgbgrid shouldBe a [RGBpixelGrid]
  }

  test("Wrong input") {
    val pngLoader = new PngLoader("Season4jpg.jpg")
    assertThrows[IllegalArgumentException](pngLoader.LoadImage())
  }


  test("Very wrong input") {
    val pngLoader = new PngLoader("fgfhfghfgpng")
    assertThrows[IllegalArgumentException](pngLoader.LoadImage())
  }

}
