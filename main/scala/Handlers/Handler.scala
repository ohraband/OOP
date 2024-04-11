package Handlers

import scala.annotation.tailrec

//general handler, inspired by tutorials
trait Handler[T]
{
  def handle(item: T): Option[Handler[T]]

  def setNext(nextHandler: Handler[T]): Handler[T]
}

object Handler{

  //function that uns through all the handlers in a chain and processes the given command
  def ProcessOneCommand[T](handlerChain: Handler[T], command: T): Unit = {

    @tailrec
    def IterateThroughHandlers(handlerChain: Handler[T]): Unit = {
      handlerChain.handle(command) match {
        case Some(nextHandler) => IterateThroughHandlers(nextHandler) //found nothing in this handler, try next one in the chain
        case None => //quit the thing as something got found so we don't need another handler
      }
    }

    IterateThroughHandlers(handlerChain)
  }
}
