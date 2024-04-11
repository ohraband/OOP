package HandlerControllers

import Export.{ConsoleExport, FileExport}
import Filter.{Brightness, Flip, Invert}
import Image.Image
import TableConversion.ConversionTable

//controller handling the filter and export functions on the given image and conversion table
case class MainController(private var image : Image, convTable : ConversionTable) {

  def brightness(value : Int): Unit = {
    val Brightnessclass = new Brightness(value)
    image = Brightnessclass.apply(image)
  }

  def consoleExport(): Unit = {
    val exporter = new ConsoleExport()
    exporter.export(image.makeStringImage(convTable))
  }

  def fileExport(file : String): Unit = {
    val exporter = new FileExport(file)
    exporter.export(image.makeStringImage(convTable))
  }

  def flip(direction : String): Unit = {
    val flipclass = new Flip(direction)
    image = flipclass.apply(image)
  }

  def invert(): Unit = {
    val invertclass = new Invert()
    image = invertclass.apply(image)
  }


}
