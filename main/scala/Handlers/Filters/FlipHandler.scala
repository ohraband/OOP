package Handlers.Filters

import HandlerControllers.MainController
import Handlers.RegexHandler

class FlipHandler(controller: MainController)
  extends RegexHandler("flip \"(.)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    val direction = args.head

    controller.flip(direction)
  }
}