package TableConversion

import org.scalatest.FunSuite

class DefaultTableTest extends FunSuite {

  val defaultTable = new DefaultTable

  test("testNormalValue") {
    assert(defaultTable.apply(120) == '7')
    assert(defaultTable.apply(180) == '|')
  }

  test("testMin") {
    assert(defaultTable.apply(-84) == 'W' )
  }

  test("testMax") {
    assert(defaultTable.apply(456) == ' ')
  }

}
