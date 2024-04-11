package Loader


import PixelGrid.RGBpixelGrid.RGBpixelGrid

import java.io.File
import javax.imageio.ImageIO

//loads a jpg image
class JpgLoader(name: String) extends LoadImage {
   override def LoadImage(): RGBpixelGrid ={
     val Pattern = "(.*\\.jpg)".r
    name match {
      case Pattern(name) => val image = ImageIO.read(new File(name))
         BufferedImageToRGBGrid(image)
      case _ => throw new IllegalArgumentException("Wrong .jpg filename")
    }
   }
}
