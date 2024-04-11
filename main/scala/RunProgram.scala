import GreyscaleConverter.{DefaultGreyscaleConverter, RGBtoGreyscale}
import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import HandlerControllers.{InitialController, MainController}
import Handlers.ConversionTables.{CustomTableHandler, DefaultTableHandler, NonlinearTableHandler}
import Handlers.Exports.{ExportCommandlineHandler, ExportToFileHandler}
import Handlers.Filters.{BrightnessHandler, FlipHandler, InvertHandler}
import Handlers.Loaders.{GenerateImageLoadHandler, GifLoadHandler, JpgLoadHandler, PngLoadHandler}
import Handlers.{CommandHandler, Handler, UnknownCommandHandler}
import Image.Image
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.DefaultTable

import scala.io.StdIn

class RunProgram {
  def run(input : String): Unit = {

      //deal with multiple --image commands
      if(!imagecountcheckproceed(input)){
        return
      }

      //separete commands and put them into a sequence
      val inputdashsplit: Seq[String] = input.split("--").map(_.trim).toList
      val inputdashseparated: Seq[String] = inputdashsplit.slice(1,inputdashsplit.length)

      //set image and conversion table
      val initialController = new InitialController(new RGBpixelGrid(Array[Array[Pixel]]()), new DefaultTable)
      inputdashseparated.foreach {
        //println("Running Initial handler chain")
        command => Handler.ProcessOneCommand(loadHandlerChain(initialController), command)
      }

      //run everything else
      if (initialController.GetRGBpixelGrid().isEmpty) {
        println("No actual image was set.")
      }
      else {
        //since there is no --greyscaleconverter "type" command, default is used
        val RGBtoGreyscale = new RGBtoGreyscale
        val greyscaleconverter = new DefaultGreyscaleConverter

        val greygrid: GreyscalePixelGrid = RGBtoGreyscale(greyscaleconverter, initialController.GetRGBpixelGrid())
        val initialImage = new Image(greygrid)


        val controller = MainController(initialImage, initialController.GetTable())
        inputdashseparated.foreach {
          //println("Running Main handler chain")
          command => Handler.ProcessOneCommand(handlerChain(controller), command)
        }

      }

      println("Commands finished")

    }






    def loadHandlerChain(controller: InitialController): CommandHandler = {
      val JpgLoadHandler = new JpgLoadHandler(controller)
      val PngLoadHandler = new PngLoadHandler(controller)
      val GifLoadHandler = new GifLoadHandler(controller)
      val GenerateImageLoadHandler = new GenerateImageLoadHandler(controller)
      val DefaultTableHandler = new DefaultTableHandler(controller)
      val NonlinearTableHandler = new NonlinearTableHandler(controller)
      val CustomTableHandler = new CustomTableHandler(controller)

      val initialHandler: CommandHandler = JpgLoadHandler
      initialHandler
        .setNext(GenerateImageLoadHandler)
        .setNext(GifLoadHandler)
        .setNext(PngLoadHandler)
        .setNext(DefaultTableHandler)
        .setNext(NonlinearTableHandler)
        .setNext(CustomTableHandler)
        .setNext(new UnknownCommandHandler)

      initialHandler
    }

    def handlerChain(controller: MainController): CommandHandler = {
      val BrightnessHandler = new BrightnessHandler(controller)
      val ExportCommandlineHandler = new ExportCommandlineHandler(controller)
      val ExportToFileHandler = new ExportToFileHandler(controller)
      val FlipHandler = new FlipHandler(controller)
      val InvertHandler = new InvertHandler(controller)

      val initialHandler: CommandHandler = BrightnessHandler
      initialHandler
        .setNext(ExportCommandlineHandler)
        .setNext(ExportToFileHandler)
        .setNext(FlipHandler)
        .setNext(InvertHandler)
        .setNext(new UnknownCommandHandler)

      initialHandler
    }


  def imagecountcheckproceed(input : String): Boolean = {
    val imageregex = "--image".r
    imageregex.findAllIn(input).length
    if (imageregex.findAllIn(input).length > 1) {
      println("More than one image specified, only last image will be used, do you wish to proceed anyway?")
      println("Type \"y\" to proceed")
      println("Type \"n\" to quit")
      val response = StdIn.readLine()
      if (response == "y") {
        return true
      }
      else if (response == "n") {
        return false
      }
      else {
        imagecountcheckproceed(input)
      }
    }
    true
  }

}
