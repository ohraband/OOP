package TableConversion

//non linear conversion table mostly used to find edges between light and dark
class NonLinearTable  extends ConversionTable  {
   var Table = "M-. "
  override def apply(greyscaleval: Int): Char = {

    if (greyscaleval < 200){
      val getCharacterForGreyScale: Char = Table(0)
       getCharacterForGreyScale
    }
    else if (greyscaleval < 220){
      val getCharacterForGreyScale: Char = Table(1)
       getCharacterForGreyScale
    }
    else if (greyscaleval < 250){
      val getCharacterForGreyScale: Char = Table(2)
       getCharacterForGreyScale
    }
    else {
      val getCharacterForGreyScale: Char = Table(3)
       getCharacterForGreyScale
    }
  }
}
