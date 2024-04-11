package Handlers.Loaders

import HandlerControllers.InitialController
import Handlers.RegexHandler

class GifLoadHandler(controller: InitialController)
  extends RegexHandler("image \"(.*\\.gif)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    val path = args.head
    controller.GifSetImage(path)
  }
}


