package advent2016

/**
  * Created by campbell on 2016/11/23.
  */
object Main extends App {
  println("Hello World")

  FileReader.readFileByLine("src/main/resources/testFile.txt") foreach(println(_))
  FileReader.readFileByChar("src/main/resources/testFile.txt") foreach(println(_))
}
