package Handlers.Filters

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import HandlerControllers.{InitialController, MainController}
import Image.Image
import Pixel.Pixel
import TableConversion.{DefaultTable, NonLinearTable}
import org.scalatest.FunSuite

class BrightnessHandlerTest extends FunSuite {

  test("testHandle") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new BrightnessHandler(mainController)
    handler.handle("brightness \"50\"")

    assert(! (mainController equals newmainController) )
  }

  test("testProcessCommand") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new BrightnessHandler(mainController)
    val args = Seq[String]("50")
    handler.processCommand(args)

    assert(! (mainController equals newmainController) )
  }



  test("testHandleWrong") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val table = new DefaultTable
    val mainController =  MainController(testimage, table)
    val newmainController =  MainController(testimage, table)
    val handler = new BrightnessHandler(mainController)
    handler.handle("WrongInput")

    assert ( mainController equals newmainController )
  }

  test("testProcessCommandWrong") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val handler = new BrightnessHandler(mainController)
    val args = Seq[String]("WrongInput")

    assertThrows[IllegalArgumentException](handler.processCommand(args))
  }

}
