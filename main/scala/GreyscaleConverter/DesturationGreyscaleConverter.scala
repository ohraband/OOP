package GreyscaleConverter
import Pixel.Pixel

//greyscale algorithm that resembles desaturated image
class DesturationGreyscaleConverter extends GreyscaleConverter {
  override def apply(RGBpixel : Pixel): Pixel ={
    val r = (RGBpixel.getValue >> 16) & 0xFF
    val g = (RGBpixel.getValue >> 8) & 0xFF
    val b = RGBpixel.getValue & 0xFF
    val greyscalevalue = ( (r max g max b ) + (r min g min b) ) / 2

    new Pixel(0 max greyscalevalue min 255)
  }

}
