package advent2016

/**
  * Created by campbell on 2016/11/23.
  */
object Main extends App {
  println("Hello World")

  FileReader.readFileByLine("src/test/resources/testFile.txt") foreach(println(_))
  FileReader.readFileByChar("src/test/resources/testFile.txt") foreach(println(_))
}
