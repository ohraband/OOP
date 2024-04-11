package Handlers.Filters

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import HandlerControllers.MainController
import Image.Image
import Pixel.Pixel
import TableConversion.DefaultTable
import org.scalatest.FunSuite

class InvertHandlerTest extends FunSuite {

  test("testHandle") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new InvertHandler(mainController)
    handler.handle("invert")

    assert(! (mainController equals newmainController) )
  }

  test("testProcessCommand") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new InvertHandler(mainController)
    val args = Seq[String]("")
    handler.processCommand(args)

    assert(! (mainController equals newmainController) )
  }



  test("testHandleWrong") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val table = new DefaultTable
    val mainController =  MainController(testimage, table)
    val newmainController =  MainController(testimage, table)
    val handler = new InvertHandler(mainController)
    handler.handle("WrongInput")

    assert ( mainController equals newmainController )
  }

}
