package Handlers.Loaders

import HandlerControllers.InitialController
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{DefaultTable, NonLinearTable}
import org.scalatest.FunSuite

class GenerateImageLoadHandlerTest extends FunSuite {

  test("testHandle") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new GenerateImageLoadHandler(initialController)
    handler.handle("image-random")
    initialController.GetRGBpixelGrid != emptyrgbgrid
  }

  test("testHandleWrong") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new GenerateImageLoadHandler(initialController)
    handler.handle("WrongInput")
    initialController.GetRGBpixelGrid equals emptyrgbgrid
  }


  test("testProcessCommand") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new GenerateImageLoadHandler(initialController)
    val args = Seq[String]("")
    handler.processCommand(args)
    initialController.GetRGBpixelGrid != emptyrgbgrid
  }

}
