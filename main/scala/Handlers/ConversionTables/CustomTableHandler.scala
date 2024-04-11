package Handlers.ConversionTables

import HandlerControllers.InitialController
import Handlers.RegexHandler

class CustomTableHandler(controller: InitialController)
  extends RegexHandler("custom-table \"(.+)\"".r) {
  def processCommand(args: Seq[String]): Unit = {
    val table = args.head
    controller.CustomTable(table)
  }
}