package advent2016

import scala.io.Source

/**
  * Created by campbell on 2016/11/23.
  */
object FileReader {
  def readFileByLine(filePath: String): Iterator[String] = getFile(filePath).getLines()

  def readFileByChar(filePath: String): Iterator[Char] = getFile(filePath)

  def getFile(filePath: String) = Source.fromFile(filePath)
}
