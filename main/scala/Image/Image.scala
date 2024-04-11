package Image

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import GreyscaletoASCII.GreyscaletoASCII
import Pixel.Pixel
import TableConversion.ConversionTable

//image class holding the image in pixel form
class Image(
  var pixels: GreyscalePixelGrid) {
  private val X: Int = pixels.Width()
  private val Y: Int = pixels.Height()

  //create a string representation of the Image
  def makeStringImage(ConvTable: ConversionTable): StringImage={
    val GreyscaletoASCII = new GreyscaletoASCII
    val AsciiString: String = GreyscaletoASCII.makeASCII(this,ConvTable)
    new StringImage(AsciiString)
  }

  def GetPixel(x: Int, y: Int): Pixel ={
    if( x < X && y < Y ){
      pixels.GetPixel(x,y)
    }
    else{
      throw new IllegalArgumentException("pixel out of bounds")
    }
  }
  def GetPixelValue(x: Int, y: Int): Int ={
    if( x < X && y < Y ){
      pixels.GetPixelValue(x,y)
    }
    else{
      throw new IllegalArgumentException("pixel out of bounds")
    }
  }

  def isEmpty: Boolean = {
    pixels.isEmpty
  }

  def GetX(): Int ={
    X
  }

  def GetY(): Int ={
    Y
  }
}
