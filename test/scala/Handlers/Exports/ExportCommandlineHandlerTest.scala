package Handlers.Exports

import Export.ConsoleExport
import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import HandlerControllers.MainController
import Handlers.Filters.{BrightnessHandler, FlipHandler}
import Image.{Image, StringImage}
import Pixel.Pixel
import TableConversion.DefaultTable
import org.scalatest.FunSuite

class ExportCommandlineHandlerTest extends FunSuite {

  test("testProcessCommand") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val handler = new ExportCommandlineHandler(mainController)
    val args = Seq[String]("")
    handler.processCommand(args)

    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) { handler.processCommand(args) }
    assert(stream.toString.nonEmpty)

  }
  test("testHandle") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val handler = new ExportCommandlineHandler(mainController)

    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) { handler.handle("output-console") }
    assert(stream.toString.nonEmpty)
  }

  test("testHandleWrong") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val table = new DefaultTable
    val mainController =  MainController(testimage, table)
    val handler = new ExportCommandlineHandler(mainController)

    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) { handler.handle("WrongInput") }
    assert(stream.toString.isEmpty)
  }

}
