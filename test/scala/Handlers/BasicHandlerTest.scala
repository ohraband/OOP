package Handlers

import org.scalatest.FunSuite
import org.scalatest.Matchers.{a, convertToAnyShouldWrapper, equal}

import scala.language.postfixOps

class BasicHandlerTest extends FunSuite {

  test("testEmpty") {
    val handler = new BasicHandler[Nothing]
    val emptyhandler = handler.empty()
    emptyhandler shouldBe a [BasicHandler[Nothing]]
  }

  test("testSetNext") {
    val handler = new BasicHandler[Int]
    assert(handler.nextHandler.isEmpty)
    val anotherhandler = new BasicHandler[Int]
    handler.setNext(anotherhandler)
    assert(handler.nextHandler.isDefined)
    val yetanotherhadnler = handler.handle(2)
    assert(yetanotherhadnler.get equals anotherhandler)
  }

  test("testNextHandler_$eq") {

  }

  test("testHandle") {

  }

  test("testNextHandler") {

  }

}
