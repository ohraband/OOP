package Handlers

import HandlerControllers.InitialController
import Handlers.RegexHandler

class UnknownCommandHandler()
  extends RegexHandler("(.*)".r) {
  def processCommand(args: Seq[String]): Unit = {
      //val command = args.head
      //println(s"This command was not recognized: $command")
  }
}