package PixelGrid

import Pixel.Pixel

//generic trait fo storing pixels in some grid
trait PixelGrid {
  def Height(): Int

  def Width(): Int

  def GetPixel(x: Int, y: Int): Pixel

  def isEmpty: Boolean
}
