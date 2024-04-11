package Loader

import PixelGrid.RGBpixelGrid.RGBpixelGrid

//generic trait for converting whatever (image) into a rgb pixel grid
trait LoadImage {
  def LoadImage(): RGBpixelGrid
}
