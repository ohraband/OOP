package Handlers.Loaders

import HandlerControllers.InitialController
import Handlers.RegexHandler

class PngLoadHandler(controller: InitialController)
  extends RegexHandler("image \"(.*\\.png)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    val path = args.head
    controller.PngSetImage(path)
  }
}

