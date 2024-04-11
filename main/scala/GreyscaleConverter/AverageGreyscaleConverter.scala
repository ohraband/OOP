package GreyscaleConverter
import Pixel.Pixel

//converts to greyscale by treating each color as equally important
class AverageGreyscaleConverter extends GreyscaleConverter{
  override def apply(RGBpixel : Pixel): Pixel ={
    val r = (RGBpixel.getValue >> 16) & 0xFF
    val g = (RGBpixel.getValue >> 8) & 0xFF
    val b = RGBpixel.getValue & 0xFF
    val greyscalevalue = ((0.3334 * r) + (0.3334 * g) + (0.3334 * b)).toInt

    new Pixel(0 max greyscalevalue min 255 )
  }

}
