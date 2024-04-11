package TableConversion

//linear custom conversion table accepting a custom String input
class CustomTable(CustomTable: String) extends ConversionTable {
   var Table: String = CustomTable

  override def apply(greyscaleval: Int): Char = {
    var TableLength: Int = Table.length
    var getCharacterForGreyScale: Char = Table( (TableLength - 1) min ((TableLength - 1) * greyscaleval / 255).ceil.toInt  max 0 )

    getCharacterForGreyScale
  }
}
