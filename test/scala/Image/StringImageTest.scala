package Image

import org.scalatest.FunSuite

class StringImageTest extends FunSuite {

  test("testGetString") {
    val stringimage = new StringImage("abcd")
    assert(stringimage.GetString() == "abcd")
  }

  test("testGetStringEmpty") {
    val stringimage = new StringImage("")
    assert(stringimage.GetString().isEmpty)
  }

}
