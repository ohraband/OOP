package Handlers.Exports

import HandlerControllers.MainController
import Handlers.RegexHandler

class ExportCommandlineHandler(controller: MainController)
  extends RegexHandler("output-console".r) {
  def processCommand(args: Seq[String]): Unit = {
    controller.consoleExport()
  }
}
