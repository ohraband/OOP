import scala.io.StdIn

object main{
  def main(args: Array[String]): Unit = {
    println("Hello, world")
    val program = new RunProgram

    while (true){
      //read input
      val input = StdIn.readLine()
      //quit if user wants to quit
      if (input.startsWith("stop") || input.startsWith("exit") || input.startsWith("quit") || input.startsWith("end") || input.startsWith("finish") || input.startsWith("conclude")
        || input.startsWith("halt") || input.startsWith("break") || input.startsWith("close") || input.startsWith("leave") || input.startsWith("terminate")
        || input.startsWith(":q") || input.startsWith(":wq")
      ) {
        println("Stopping program.")
        return
      }
      //usage help
      else if (input.startsWith("help")) {
        println("Type -- followed by a command to run the program")
        println("Commands are: ")
        println("--image \"example.jpg\"  ; supported formats include: jpg, png, gif")
        println("--image-random  ; to create a grid of random pixels")
        println("--table \"type\"  ; set ascii conversion table, supported types include: default, nonlinear")
        println("--custom-table  \"[custom characters]\" ; set custom ascii conversion table, input from darkest to brightest")
        println("--output-console  ; print ascii to console")
        println("--output-file \"example.txt\" ; note that output is text")
        println("--flip \"direction\" ; flip image")
        println("--brightness \"37\" ; changes image brightness, note that values outside (-255;255) will get reduced")
        println("--invert ; inverts image colors")
        println()
        println("Type \"stop\" or just about any other similar word to quit the program.")
      }
      else{
        //actual commands processing
        program.run(input)
      }

      println("end of cycle")
      //println("(you can now input a new set of commands if you want)")

    }

  }

}
