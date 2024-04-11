package Handlers.ConversionTables

import HandlerControllers.InitialController
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{CustomTable, DefaultTable}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper}

class CustomTableHandlerTest extends FunSuite {


  test("testHandle") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    val handler = new CustomTableHandler(initialController)
    handler.handle("custom-table \"M7('. \"")
    initialController.GetTable() shouldBe a [CustomTable]
  }

  test("testHandleWrong") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    val handler = new CustomTableHandler(initialController)
    handler.handle("WrongInput")
    initialController.GetTable() shouldBe a [DefaultTable]
  }


  test("testProcessCommand") {
    val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
    val handler = new CustomTableHandler(initialController)
    val args = Seq[String]("\"M7('. \" ")
    handler.processCommand(args)
    initialController.GetTable() shouldBe a [CustomTable]
  }

}
