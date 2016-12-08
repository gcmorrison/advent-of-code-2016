package advent2016.day6

import advent2016.FileReader

/**
  * Created by campbell on 2016/12/07.
  */
object NoisySignals {
  def explode(input: String): List[String] = input.toList.map(char => s"$char")

  def merge(list: List[String], input: String) = list.zip(explode(input)).map(tuple => s"${tuple._1}${tuple._2}")

  def buildOccurrenceList(input: String) = input.toList
      .groupBy(char => char)
      .map(element => element._1 -> element._2.size)
      .toList

  def mostCommon(input: String) = buildOccurrenceList(input)
      .sortWith((left, right) => left._2 > right._2)
      .head._1

  def leastCommon(input: String) = buildOccurrenceList(input)
      .sortWith((left, right) => left._2 < right._2)
      .head._1

  def decode(lines: Iterator[String])(find: (String => Char)): String = {
    def combineEncodings(acc: List[String]): List[String] = lines.hasNext match {
      case false => acc
      case true => combineEncodings(merge(acc, lines.next))
    }

    combineEncodings(explode(lines.next))
      .map(find) mkString ""
  }

  def part1(inputFile: String): Unit = {
    println(s"Part1: The decoded message: ${decode(FileReader.readFileByLine(inputFile))(mostCommon)}")
  }

  def part2(inputFile: String): Unit = {
    println(s"Part2: The decoded message: ${decode(FileReader.readFileByLine(inputFile))(leastCommon)}")
  }
}
