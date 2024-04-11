package GreyscaleConverter
import Pixel.Pixel

//only takes the green component of the image to convert to greyscale
class OnlyGreenGreyscaleConverter extends GreyscaleConverter{
  override def apply(RGBpixel : Pixel): Pixel ={
    val g = (RGBpixel.getValue >> 8) & 0xFF
    val greyscalevalue = g

    new Pixel(0 max greyscalevalue min 255)
  }
}
