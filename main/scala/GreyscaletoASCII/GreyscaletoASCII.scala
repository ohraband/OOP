package GreyscaletoASCII

import Image.Image
import TableConversion.ConversionTable

//takes an image (ideally with grey pixels) and converts it to ascii-image string
class GreyscaletoASCII {
   def makeASCII(image: Image, convTable: ConversionTable): String ={
     var line: String = ""
     for(y <- 0 until image.GetY()){
       var oneline : String = ""
      for(x <- 0 until image.GetX()){
        oneline = oneline + convTable(image.GetPixelValue(x,y))
      }
       if(y < image.GetY() -1) {
         oneline = oneline + sys.props("line.separator")
         }
       line = line + oneline
     }
     line
  }
}
