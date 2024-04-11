package Handlers

import scala.util.matching.Regex

abstract class RegexHandler(regExp: Regex) extends CommandHandler {

  override def handle(command: String): Option[Handler[String]] =
    command match {
      case regExp(all @ _*) =>
        //println("Command is: ", command)
        //println("All is: ", all)
        processCommand(all)
        None
      case _ =>
        super.handle(command)
    }
}

