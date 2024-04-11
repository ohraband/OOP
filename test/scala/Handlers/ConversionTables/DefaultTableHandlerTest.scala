package Handlers.ConversionTables

import HandlerControllers.InitialController
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{CustomTable, DefaultTable, NonLinearTable}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class DefaultTableHandlerTest extends FunSuite {

  test("testHandle") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new NonLinearTable)
    val handler = new DefaultTableHandler(initialController)
    handler.handle("table \"default\"")
    initialController.GetTable() shouldBe a [DefaultTable]
  }

  test("testHandleWrong") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new NonLinearTable)
    val handler = new DefaultTableHandler(initialController)
    handler.handle("WrongInput")
    initialController.GetTable() shouldBe a [NonLinearTable]
  }


  test("testProcessCommand") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new NonLinearTable)
    val handler = new DefaultTableHandler(initialController)
    val args = Seq[String]("")
    handler.processCommand(args)
    initialController.GetTable() shouldBe a [DefaultTable]
  }

}
