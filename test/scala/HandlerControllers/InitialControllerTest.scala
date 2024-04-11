package HandlerControllers

import Loader.{GifLoader, JpgLoader, PngLoader}
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{CustomTable, DefaultTable, NonLinearTable}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class InitialControllerTest extends FunSuite {

  test("testPngSetImage") {
    val pngloader = new PngLoader("Season4png.png")
    val grid1 = pngloader.LoadImage()
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    initialController.PngSetImage("Season4png.png")

    for(x <- 0 until grid1.Width() ){
      for(y <- 0 until grid1.Height() ){
        assert( grid1.GetPixelValue(x,y) == initialController.GetRGBpixelGrid().GetPixelValue(x,y) )
      }
    }
  }

  test("testCustomTable") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    initialController.CustomTable("abcd")
    initialController.GetTable() shouldBe a [CustomTable]
  }

  test("testGifSetImage") {
    val pngloader = new GifLoader("Season4gif.gif")
    val grid1 = pngloader.LoadImage()
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    initialController.GifSetImage("Season4gif.gif")

    for(x <- 0 until grid1.Width() ){
      for(y <- 0 until grid1.Height() ){
        assert( grid1.GetPixelValue(x,y) == initialController.GetRGBpixelGrid().GetPixelValue(x,y) )
      }
    }

  }

  test("testNonLinearTable") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    initialController.NonLinearTable()
    initialController.GetTable() shouldBe a [NonLinearTable]
  }


  test("testGetTable") {
    val table = new DefaultTable
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), table)
    assert(initialController.GetTable() equals table)
  }

  test("testGetRGBpixelGrid") {
    val grid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(grid, new DefaultTable)
    assert(initialController.GetRGBpixelGrid() equals grid)
  }

  test("testGenerateImage") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    initialController.GenerateImage()
    assert(! initialController.GetRGBpixelGrid().isEmpty)
  }



  test("testDefaultTable") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new NonLinearTable)
    initialController.DefaultTable()
    initialController.GetTable() shouldBe a [DefaultTable]

  }

  test("testJpgSetImage") {
    val pngloader = new JpgLoader("Season4jpg.jpg")
    val grid1 = pngloader.LoadImage()
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    initialController.JpgSetImage("Season4jpg.jpg")

    for(x <- 0 until grid1.Width() ){
      for(y <- 0 until grid1.Height() ){
        assert( grid1.GetPixelValue(x,y) == initialController.GetRGBpixelGrid().GetPixelValue(x,y) )
      }
    }

  }

  test("testInitialTable") {

  }

}
