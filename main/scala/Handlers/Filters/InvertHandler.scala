package Handlers.Filters

import HandlerControllers.MainController
import Handlers.RegexHandler

class InvertHandler(controller: MainController)
  extends RegexHandler("invert".r) {
  def processCommand(args: Seq[String]): Unit = {
    controller.invert()
  }
}