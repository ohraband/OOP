package TableConversion

import org.scalatest.FunSuite

class NonLinearTableTest extends FunSuite {

  val nonlinearTable = new NonLinearTable

  test("testNormalValue") {
    assert(nonlinearTable.apply(120) == 'M')
    assert(nonlinearTable.apply(235) == '.')
  }

  test("testMin") {
    assert(nonlinearTable.apply(-84) == 'M' )
  }

  test("testMax") {
    assert(nonlinearTable.apply(456) == ' ')
  }

}
