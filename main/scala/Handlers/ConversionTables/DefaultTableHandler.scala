package Handlers.ConversionTables

import HandlerControllers.InitialController
import Handlers.RegexHandler

class DefaultTableHandler(controller: InitialController)
  extends RegexHandler("table \"default\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    controller.DefaultTable()
  }
}
