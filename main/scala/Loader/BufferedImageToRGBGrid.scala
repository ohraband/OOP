package Loader

import Pixel.Pixel
import java.awt.image.BufferedImage
import PixelGrid.RGBpixelGrid.RGBpixelGrid

//generic function to convert buffered image used by many file formats to a pixel grid
object BufferedImageToRGBGrid{
   def apply(image: BufferedImage): RGBpixelGrid ={
    val pixels = Array.ofDim[Pixel](image.getWidth, image.getHeight)

    for(x <- 0 until image.getWidth) {
      for(y <- 0 until image.getHeight){
        pixels(x)(y) = new Pixel(image.getRGB(x, y))
      }
    }

    new RGBpixelGrid(pixels)
  }
}
