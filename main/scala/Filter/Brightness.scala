package Filter

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel
//changes brightness of an image
class Brightness(changevalue: Int) extends Filter{
  override def apply(Image: Image): Image ={
    val newpixels = Array.ofDim[Pixel](Image.GetX(), Image.GetY())
    for (x <- 0 until Image.GetX()) {
      for (y <- 0 until Image.GetY()) {
        newpixels(x)(y) = new Pixel(clamp(Image.GetPixelValue(x,y) + changevalue, 0, 255))
      }
    }
    new Image (new GreyscalePixelGrid(newpixels))
  }

  //keeps value within specified bounds
  def clamp(value: Int, min_value: Int, max_value:Int): Int ={
    val clamped_value = min_value max value min max_value
    clamped_value
  }

}
