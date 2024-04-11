package Export

import Image.StringImage
import org.scalatest.FunSuite

import java.io.File
import javax.imageio.ImageIO
import java.io.BufferedReader
import java.io.FileReader

class FileExportTest extends FunSuite {

  test("testExport") {
    val exporter = new FileExport("randomfilename.txt")
    exporter.export(new StringImage("abcd"))

    val br = new BufferedReader(new FileReader("randomfilename.txt"))
    val sb = new StringBuilder
    var line = br.readLine

    while ( {
      line != null
    }) {
      sb.append(line)
      sb.append(System.lineSeparator)
      line = br.readLine
    }
    val everything = sb.toString

    assert(everything contains "abcd")

    new File("randomfilename.txt").delete()
  }
}
