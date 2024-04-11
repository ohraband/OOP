package Loader

import PixelGrid.RGBpixelGrid.RGBpixelGrid


import java.io.File
import javax.imageio.ImageIO

//loads a gif image
class GifLoader(name: String) extends LoadImage {
  override def LoadImage(): RGBpixelGrid ={
    val Pattern = "(.*\\.gif)".r
    name match {
      case Pattern(name) => val image = ImageIO.read(new File(name))
        BufferedImageToRGBGrid(image)
      case _ => throw new IllegalArgumentException("Wrong .gif filename")
    }
  }
}