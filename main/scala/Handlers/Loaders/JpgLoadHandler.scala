package Handlers.Loaders

import HandlerControllers.InitialController
import Handlers.RegexHandler

class JpgLoadHandler(controller: InitialController)
  extends RegexHandler("image \"(.*\\.jpg)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    val path = args.head
    controller.JpgSetImage(path)
  }
}
