package Handlers

trait CommandHandler extends BasicHandler[String]{

  def handle(command: String): Option[Handler[String]]

  protected def processCommand(args: Seq[String]): Unit
}
