package HandlerControllers

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Handlers.Exports.{ExportCommandlineHandler, ExportToFileHandler}
import Image.Image
import Pixel.Pixel
import TableConversion.DefaultTable
import org.scalatest.FunSuite

class MainControllerTest extends FunSuite {


  test("testConsoleExport") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)

    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) { mainController.consoleExport() }
    assert(stream.toString.nonEmpty)

  }

  test("testFlip") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    mainController.flip("y")

    assert(! (mainController equals newmainController) )

  }

  test("testBrightness") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    mainController.brightness(20)

    assert(! (mainController equals newmainController) )

  }

  test("testInvert") {
    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    val newmainController =  MainController(testimage, new DefaultTable)
    mainController.invert()

    assert(! (mainController equals newmainController) )

  }


  test("testFileExport") {
    assert(! new java.io.File("testexport.txt").exists)

    val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(1), new Pixel(2)),
      Array(new Pixel(3), new Pixel(4)))     )  ) // [[1,2],[3,4]]
    val mainController =  MainController(testimage, new DefaultTable)
    mainController.fileExport("testexport.txt")

    assert(new java.io.File("testexport.txt").exists)
    new java.io.File("testexport.txt").delete()
  }

}
