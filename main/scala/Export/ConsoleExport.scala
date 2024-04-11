package Export

import Image.StringImage

//exports image from it's ascii version to console
class ConsoleExport extends ImageExport{
    override def export(AsciiString: StringImage): Unit ={
      println(AsciiString.GetString())
    }
}
