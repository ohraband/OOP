package Handlers.Exports

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import HandlerControllers.MainController
import Handlers.Filters.{BrightnessHandler, FlipHandler}
import Image.Image
import Pixel.Pixel
import TableConversion.DefaultTable
import org.scalatest.FunSuite

class ExportToFileHandlerTest extends FunSuite {

  test("testProcessCommand") {

    assert(! new java.io.File("testexport.txt").exists)

    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new ExportToFileHandler(mainController)
    val args = Seq[String]("testexport.txt")
    handler.processCommand(args)

    assert(new java.io.File("testexport.txt").exists)
    new java.io.File("testexport.txt").delete()

  }
  test("testHandle") {

    assert(! new java.io.File("testexport.txt").exists)

    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new ExportToFileHandler(mainController)
    handler.handle("output-file \"testexport.txt\"")

    assert(new java.io.File("testexport.txt").exists)
    new java.io.File("testexport.txt").delete()
  }

  test("testHandleWrong") {

    assert(! new java.io.File("testexport.txt").exists)

    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val table = new DefaultTable
    val mainController =  MainController(testimage, table)
    val newmainController =  MainController(testimage, table)
    val handler = new ExportToFileHandler(mainController)
    handler.handle("WrongInput")

    assert(! new java.io.File("testexport.txt").exists)
  }

}
