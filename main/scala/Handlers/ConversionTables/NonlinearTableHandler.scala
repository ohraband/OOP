package Handlers.ConversionTables

import HandlerControllers.InitialController
import Handlers.RegexHandler

class NonlinearTableHandler(controller: InitialController)
  extends RegexHandler("table \"nonlinear\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    controller.NonLinearTable()
  }
}
