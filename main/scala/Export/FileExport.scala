package Export

import Image.StringImage


import java.io.{BufferedWriter, File, FileWriter}

//creates a new file and writes ascii into it
class FileExport(val fileName: String) extends ImageExport {
  override def export(AsciiString: StringImage): Unit = {
    val asciiimage = new File(fileName)
    val bw = new BufferedWriter(new FileWriter(asciiimage))
    bw.write(AsciiString.GetString())
    bw.close()
  }
}
