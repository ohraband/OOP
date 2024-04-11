package Handlers.Loaders

import HandlerControllers.InitialController
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.NonLinearTable
import org.scalatest.FunSuite

class PngLoadHandlerTest extends FunSuite {

  test("testHandle") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new PngLoadHandler(initialController)
    handler.handle("image \"Season4png.png\"")
    initialController.GetRGBpixelGrid != emptyrgbgrid
  }

  test("testHandleWrong") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new PngLoadHandler(initialController)
    handler.handle("WrongInput")
    initialController.GetRGBpixelGrid equals emptyrgbgrid
  }


  test("testProcessCommand") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new PngLoadHandler(initialController)
    val args = Seq[String]("Season4png.png")
    handler.processCommand(args)
    initialController.GetRGBpixelGrid != emptyrgbgrid
  }

  test("testProcessCommandWrong") {
    val emptyrgbgrid = new RGBpixelGrid(Array[Array[Pixel]]())
    val initialController = new InitialController(emptyrgbgrid, new NonLinearTable)
    val handler = new PngLoadHandler(initialController)
    val args = Seq[String]("WrongInput")
    assertThrows[IllegalArgumentException](handler.processCommand(args))
    initialController.GetRGBpixelGrid == emptyrgbgrid
  }

}
