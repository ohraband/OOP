package GreyscaleConverter
import Pixel.Pixel

//most used greyscale conversion algorithm
class DefaultGreyscaleConverter extends GreyscaleConverter{
  override def apply(RGBpixel : Pixel): Pixel ={
    val r = (RGBpixel.getValue >> 16) & 0xFF
    val g = (RGBpixel.getValue >> 8) & 0xFF
    val b = RGBpixel.getValue & 0xFF
    val greyscalevalue = ((0.3 * r) + (0.59 * g) + (0.11 * b)).toInt

    new Pixel(0 max greyscalevalue min 255)
  }
}