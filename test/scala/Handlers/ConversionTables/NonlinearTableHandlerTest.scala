package Handlers.ConversionTables

import HandlerControllers.InitialController
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{CustomTable, DefaultTable, NonLinearTable}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class NonlinearTableHandlerTest extends FunSuite {

  test("testHandle") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    val handler = new NonlinearTableHandler(initialController)
    handler.handle("table \"nonlinear\"")
    initialController.GetTable() shouldBe a [NonLinearTable]
  }

  test("testHandleWrong") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    val handler = new NonlinearTableHandler(initialController)
    handler.handle("WrongInput")
    initialController.GetTable() shouldBe a [DefaultTable]
  }


  test("testProcessCommand") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    val handler = new NonlinearTableHandler(initialController)
    val args = Seq[String]("")
    handler.processCommand(args)
    initialController.GetTable() shouldBe a [NonLinearTable]
  }

}
