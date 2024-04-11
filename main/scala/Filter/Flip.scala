package Filter

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel

//flips image in specified direction
class Flip(direction: String) extends Filter{
  override def apply(Image: Image): Image ={
    direction match {
      case "x" => FlipX(Image)
      case "y" => FlipY(Image)
      case _ => throw new IllegalArgumentException("Unsupported Flip filter argument")
    }
  }

  def FlipX(Image: Image): Image ={
    val newpixels = Array.ofDim[Pixel](Image.GetX(), Image.GetY())
    for (x <- 0 until Image.GetX()) {
      for (y <- 0 until Image.GetY()) {
        newpixels(x)(Image.GetY() - y - 1 ) = new Pixel(Image.GetPixelValue(x,y))
      }
    }
    new Image (new GreyscalePixelGrid(newpixels))
  }


  def FlipY(Image: Image): Image ={
    val newpixels = Array.ofDim[Pixel](Image.GetX(), Image.GetY())
    for (x <- 0 until Image.GetX()) {
      for (y <- 0 until Image.GetY()) {
        newpixels(Image.GetX() - x - 1)(y) = new Pixel(Image.GetPixelValue(x,y))
      }
    }
    new Image (new GreyscalePixelGrid(newpixels))
  }

}
