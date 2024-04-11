package Export

import Image.StringImage
import org.scalatest.FunSuite

class ConsoleExportTest extends FunSuite {

  test("testExport") {
      val exporter = new ConsoleExport
      val stream = new java.io.ByteArrayOutputStream()
      Console.withOut(stream) { exporter.export(new StringImage("abcdefgh") ) }
      assert(stream.toString contains "abcdefgh")
  }

  test("testExportEmpty") {
    val exporter = new ConsoleExport
    val stream = new java.io.ByteArrayOutputStream()
    Console.withOut(stream) { exporter.export(new StringImage("Seeland is a town in the Salzlandkreis district, in Saxony-Anhalt, Germany. It is situated northwest of Aschersleben. It was formed by the merger of the previously independent municipalities Friedrichsaue, Frose, Hoym, Nachterstedt and Schadeleben on 15 July 2009") ) }
    assert(stream.toString contains "Seeland is a town in the Salzlandkreis district, in Saxony-Anhalt, Germany. It is situated northwest of Aschersleben. It was formed by the merger of the previously independent municipalities Friedrichsaue, Frose, Hoym, Nachterstedt and Schadeleben on 15 July 2009")
  }

}
