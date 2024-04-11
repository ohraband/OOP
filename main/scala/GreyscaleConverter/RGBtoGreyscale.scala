package GreyscaleConverter

import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid
import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid

//class for converting rgb grid of pixels to grey grid of pixels when given a specific conversion method
class RGBtoGreyscale {
  def apply(Converter: GreyscaleConverter, imagegrid: RGBpixelGrid): GreyscalePixelGrid ={
    val pixels = Array.ofDim[Pixel](imagegrid.Width(), imagegrid.Height())

    for(x <- 0 until imagegrid.Width()) {
      for(y <- 0 until imagegrid.Height()){
        pixels(x)(y) = Converter(imagegrid.GetPixel(x,y))
      }
    }

    new GreyscalePixelGrid(pixels)
  }
}
