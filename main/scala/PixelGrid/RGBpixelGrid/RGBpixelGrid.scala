package PixelGrid.RGBpixelGrid

import Pixel.Pixel
import PixelGrid.PixelGrid

//grid of rgb pixels
class RGBpixelGrid(var pixels: Array[Array[Pixel]]) extends PixelGrid {
      private val X: Int = pixels.length
      private val Y: Int = if (pixels.nonEmpty) pixels(0).length else 0


      def Height(): Int ={
            Y
      }

      def Width(): Int ={
            X
      }

      def GetPixel(x: Int, y: Int): Pixel =
            if( X > x && Y > y ){
                  pixels(x)(y)
            }
            else{
                  throw new IllegalArgumentException("pixel out of bounds")
            }

      def GetPixelValue(x: Int, y: Int): Int ={
            if( X > x && y < Y ){
                  pixels(x)(y).getValue
            }
            else{
                  throw new IllegalArgumentException("pixel out of bounds")
            }
      }

      def isEmpty: Boolean ={
            pixels.isEmpty
      }
}
