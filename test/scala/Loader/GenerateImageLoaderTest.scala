package Loader

import PixelGrid.RGBpixelGrid.RGBpixelGrid
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class GenerateImageLoaderTest extends FunSuite {

  test("testLoadImage") {
    val generateImageLoader = new GenerateImageLoader()
    val rgbgrid = generateImageLoader.LoadImage()
    rgbgrid shouldBe a [RGBpixelGrid]
  }

}
