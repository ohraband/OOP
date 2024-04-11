package Loader

import org.scalatest.FunSuite

import java.awt.image.BufferedImage
import java.io.{BufferedWriter, File, FileWriter}
import javax.imageio.ImageIO

class BufferedImageToRGBGridTest extends FunSuite {


  val image: BufferedImage = ImageIO.read(new File("sm32.png")) //32x32 image


  test("testApply") {
    val rgbgrid = BufferedImageToRGBGrid(image)
    assert(rgbgrid.Height() == 32 )
    assert(rgbgrid.Width() == 32 )
  }

}
