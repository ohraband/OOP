package Loader
import scala.util.Random
import Pixel.Pixel
import PixelGrid.RGBpixelGrid.RGBpixelGrid

//generates a random """image""" by creating a random grid of rgb pixels
class GenerateImageLoader extends LoadImage {

  def LoadImage(): RGBpixelGrid ={
    val sizex = Random.between(20, 500)
    val sizey = Random.between(20, 500)
    val pixels = Array.ofDim[Pixel](sizex, sizey)

    for(x <- 0 until sizex) {
      for(y <- 0 until sizey){
        val r = Random.between(0, 255) >> 16
        val g = Random.between(0, 255) >> 8
        val b = Random.between(0, 255)
        val rgbpixel = r + g + b
        pixels(x)(y) = new Pixel(rgbpixel)
      }
    }

    new RGBpixelGrid(pixels)
  }
}
