package Handlers.Loaders

import HandlerControllers.InitialController
import Handlers.RegexHandler

class GenerateImageLoadHandler(controller: InitialController)
  extends RegexHandler("image-random".r) {
  def processCommand(args: Seq[String]): Unit = {
    controller.GenerateImage()
  }
}