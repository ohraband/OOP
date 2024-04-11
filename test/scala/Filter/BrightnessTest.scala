package Filter

import PixelGrid.GreyscalePixelGrid.GreyscalePixelGrid
import Image.Image
import Pixel.Pixel
import org.scalatest.FunSuite

class BrightnessTest extends FunSuite {

  val testimage = new Image(new GreyscalePixelGrid( Array(Array(new Pixel(50), new Pixel(50), new Pixel(50))  ))) //[50,50,50]

  test("testBrightnessPositiveChange") {
      val brigtness= new Brightness(15)
      val newImage = brigtness.apply(testimage)
      for(x <- 0 until newImage.GetX() ){
        for(y <- 0 until newImage.GetY() ){
          assert( newImage.GetPixelValue(x,y) == 65 )
        }
      }
  }

  test("testBrightnessNegativeChange") {
    val brigtness= new Brightness(-15)
    val newImage = brigtness.apply(testimage)
    for(x <- 0 until newImage.GetX() ){
      for(y <- 0 until newImage.GetY() ){
        assert( newImage.GetPixelValue(x,y) == 35 )
      }
    }
  }

  test("testBrightnessTooBigChange") {
    val brigtness= new Brightness(451)
    val newImage = brigtness.apply(testimage)
    for(x <- 0 until newImage.GetX() ){
      for(y <- 0 until newImage.GetY() ){
        assert( newImage.GetPixelValue(x,y) == 255 )
      }
    }
  }

  test("testBrightnessTooBigNegativeChange") {
    val brigtness= new Brightness(-451)
    val newImage = brigtness.apply(testimage)
    for(x <- 0 until newImage.GetX() ){
      for(y <- 0 until newImage.GetY() ){
        assert( newImage.GetPixelValue(x,y) == 0 )
      }
    }
  }

  test("testClampValueInBetween") {
    val brigtness = new Brightness(-451)
    val value = brigtness.clamp(154,0,255)
    assert(value == 154)
  }

  test("testClampValueTooLow") {
    val brigtness = new Brightness(-451)
    val value = brigtness.clamp(-654,0,255)
    assert(value == 0)
  }

  test("testClampValueTooHigh") {
    val brigtness = new Brightness(-451)
    val value = brigtness.clamp(1540,0,255)
    assert(value == 255)
  }



}
