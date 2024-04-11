package Filter

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel

//changes brightness of all pixels in image to their inverted value
class Invert extends Filter{
    override def apply(Image: Image): Image ={
      val newpixels = Array.ofDim[Pixel](Image.GetX(), Image.GetY())
      for (x <- 0 until Image.GetX()) {
        for (y <- 0 until Image.GetY()) {
          newpixels(x)(y) = new Pixel(255 - Image.GetPixelValue(x,y))
        }
      }
      new Image (new GreyscalePixelGrid(newpixels))
    }
}
