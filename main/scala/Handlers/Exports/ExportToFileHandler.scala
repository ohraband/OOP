package Handlers.Exports

import HandlerControllers.MainController
import Handlers.RegexHandler

class ExportToFileHandler(controller: MainController)
  extends RegexHandler("output-file \"(.*)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    val path = args.head

    //Export File
    controller.fileExport(path)
  }
}

