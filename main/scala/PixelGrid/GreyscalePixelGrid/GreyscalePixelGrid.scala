package PixelGrid.GreyscalePixelGrid

import Pixel.Pixel
import PixelGrid.PixelGrid

//grid of grey pixels
class GreyscalePixelGrid(var pixels: Array[Array[Pixel]]) extends PixelGrid{

  private val X: Int = pixels.length
  private val Y: Int = if (pixels.nonEmpty) pixels(0).length else 0

  def GetPixel(x: Int, y: Int): Pixel ={
    if( x < X && y < Y ){
      pixels(x)(y)
    }
    else{
      throw new IllegalArgumentException("pixel out of bounds")
    }
  }

  def GetPixelValue(x: Int, y: Int): Int ={
    if( x < X && y < Y ){
      pixels(x)(y).getValue
    }
    else{
      throw new IllegalArgumentException("pixel out of bounds")
    }
  }

  def Height(): Int ={
    Y
  }

  def Width(): Int ={
    X
  }

  def isEmpty: Boolean ={
    pixels.isEmpty
  }
}

