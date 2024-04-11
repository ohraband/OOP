package Handlers.Filters

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import HandlerControllers.{InitialController, MainController}
import Handlers.Loaders.GifLoadHandler
import Image.Image
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{DefaultTable, NonLinearTable}
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

import scala.language.postfixOps

class FlipHandlerTest extends FunSuite {


  test("testHandlex") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new FlipHandler(mainController)
    handler.handle("flip \"x\"")

    assert(! (mainController equals newmainController) )
  }

  test("testProcessCommandx") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new FlipHandler(mainController)
    val args = Seq[String]("x")
    handler.processCommand(args)


    assert(! (mainController equals newmainController) )
  }



  test("testHandley") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new FlipHandler(mainController)
    handler.handle("flip \"y\"")

    assert(! (mainController equals newmainController) )
  }

  test("testProcessCommandy") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    val handler = new FlipHandler(mainController)
    val args = Seq[String]("y")
    handler.processCommand(args)

    assert(! (mainController equals newmainController) )
  }



  test("testHandleWrong") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
      val table = new DefaultTable
    val mainController =  MainController(testimage, table)
    val newmainController =  MainController(testimage, table)
    val handler = new FlipHandler(mainController)
    handler.handle("WrongInput")

    assert ( mainController equals newmainController )
  }

  test("testProcessCommandWrong") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val handler = new FlipHandler(mainController)
    val args = Seq[String]("WrongInput")

    assertThrows[IllegalArgumentException](handler.processCommand(args))
  }
}
