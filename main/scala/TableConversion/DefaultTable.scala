package TableConversion

//default linear conversion table, this one is used if none are set
class DefaultTable extends ConversionTable  {
  // var Table = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. " //paul table
  // var Table = "@%#*+=-:. " //paul short table
  // var Table = "@&%QWNM0gB$#DR8mHXKAUbGOpV4d9h6PkqwSE2]ayjxY5Zoen[ult13If}C{iF|(7J)vTLs?z/*cr!+<>;=^,_:'-.`" //characters by windows font brightness, not very good
  // var Table = "WMHEFXKRPYVTA930JUOLCI7m&+=})(/|!:~-,.\"`' " //almost great, inspired by what characters are most used on some ascii images
   var Table = "WMHEFXKRPYVTA930JUOLCI7m&+=})(//||!!::~~--,.\"`' "  //best one so far, same as above but with some repetition so brightness works well linearly

  override def apply(greyscaleval: Int): Char = {
    val TableLength: Int = Table.length
    val getCharacterForGreyScale: Char = Table( (TableLength - 1) min ((TableLength - 1) * greyscaleval / 255).ceil.toInt  max 0 )

    getCharacterForGreyScale
  }
}
