package HandlerControllers

import Loader.{GenerateImageLoader, GifLoader, JpgLoader, PngLoader}
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import TableConversion.{ConversionTable, CustomTable, DefaultTable, NonLinearTable}

import scala.language.postfixOps

//controller used for initialization of the image and the conversion table
class InitialController(var initGrid : RGBpixelGrid, var initTable : ConversionTable ){

    private var initialGrid: RGBpixelGrid = initGrid
    private var initialTable: ConversionTable = initTable

    def GetTable(): ConversionTable ={
      initialTable
    }

    def GetRGBpixelGrid(): RGBpixelGrid ={
      initialGrid
    }

    def PngSetImage(file : String): Unit ={
      val loader = new PngLoader(file)
      initialGrid = loader.LoadImage()
    }

    def JpgSetImage(file : String): Unit ={
      val loader = new JpgLoader(file)
      initialGrid = loader.LoadImage()
    }

    def GifSetImage(file : String): Unit ={
      val loader = new GifLoader(file)
      initialGrid = loader.LoadImage()
    }

    def GenerateImage() : Unit = {
      val loader = new GenerateImageLoader()
      initialGrid = loader.LoadImage()
    }

    def DefaultTable() : Unit = {
      initialTable = new DefaultTable
    }

    def CustomTable(table : String) : Unit = {
      initialTable = new CustomTable(table)
    }

    def NonLinearTable() : Unit = {
      initialTable = new NonLinearTable
    }
}
