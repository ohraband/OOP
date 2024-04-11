package GreyscaleConverter

import Pixel.Pixel

//converts RGB pixels to Grey pixels
trait GreyscaleConverter {
    def apply(RGBpixel: Pixel) : Pixel
}
