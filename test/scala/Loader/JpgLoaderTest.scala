package Loader

import PixelGrid.RGBpixelGrid.RGBpixelGrid
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class JpgLoaderTest extends FunSuite {

  test("testLoadImage") {
    val jpgLoader = new JpgLoader("Season4jpg.jpg")
    val rgbgrid = jpgLoader.LoadImage()
    rgbgrid shouldBe a [RGBpixelGrid]
  }

  test("Wrong input") {
    val jpgLoader = new JpgLoader("Season4png.png")
    assertThrows[IllegalArgumentException](jpgLoader.LoadImage())
  }


  test("Very wrong input") {
    val jpgLoader = new JpgLoader("jklhsfkjhjpg")
    assertThrows[IllegalArgumentException](jpgLoader.LoadImage())
  }

}
