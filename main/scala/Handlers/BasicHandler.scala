package Handlers

//Basic handler class from which handlers inherit from, inspired by tutorials
class BasicHandler[T] extends Handler[T]
{
  var nextHandler: Option[Handler[T]] = None

  override def setNext(nextHandler: Handler[T]): Handler[T] = {
    this.nextHandler = Some(nextHandler)
    nextHandler
  }

  override def handle(item: T): Option[Handler[T]] = nextHandler

  def empty(): BasicHandler[Nothing] = new BasicHandler[Nothing]
}
