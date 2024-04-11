package TableConversion

import org.scalatest.FunSuite

class CustomTableTest extends FunSuite {

  val customTable = new CustomTable("abcdef")

  test("testNormalValue") {
    assert(customTable.apply(120) == 'c')
    assert(customTable.apply(180) == 'd')
  }

  test("testMin") {
    assert(customTable.apply(-84) == 'a')
  }

  test("testMax") {
    assert(customTable.apply(456) == 'f')
  }



}
