package Handlers.Filters

import HandlerControllers.MainController
import Handlers.RegexHandler

import scala.util.Try

class BrightnessHandler(controller: MainController)
  extends RegexHandler("brightness \"(.+)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    if (Try(args.head.toInt).isSuccess) {
      controller.brightness(args.head.toInt)
    } else {
      throw new IllegalArgumentException("Brightness wrong parameter " + args.head)
    }


  }
}
