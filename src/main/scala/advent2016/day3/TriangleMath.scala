package advent2016.day3

import advent2016.FileReader

/**
  * Created by campbell on 2016/12/05.
  */
object TriangleMath {
  def isTriangle(side1: Int, side2: Int, side3: Int): Boolean = side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1

  def splitLineIntoSides(inputLine: String): List[Int] = {
    def clean(input: String): String = if (input.contains("  ")) clean(input.replaceAll("  ", " ")) else input

    clean(inputLine).trim
      .split(' ')
      .map(_.toInt)
      .toList
  }

  def part1(inputFile: String) = {
    val triangleCount = FileReader.readFileByLine(inputFile).toList
      .map(splitLineIntoSides)
      .map(values => isTriangle(values(0), values(1), values(2)))
      .filter(triangle => triangle)
      .size

    println(s"Part1: Number of possible triangles: ${triangleCount}")
  }

  def part2(inputFile: String) = {
    val allLines = FileReader.readFileByLine(inputFile)

    val triangleCount = getTrianglesByColumn(allLines)
      .map(values => isTriangle(values(0), values(1), values(2)))
      .filter(triangle => triangle)
      .size

    println(s"Part2: Number of possible triangles: ${triangleCount}")
  }

  def getTrianglesByColumn(lines: Iterator[String]): List[List[Int]] = {
    var columnSets: List[List[Int]] = Nil

    while (lines.hasNext) {
      val line1Values = splitLineIntoSides(lines.next)
      val line2Values = splitLineIntoSides(lines.next)
      val line3Values = splitLineIntoSides(lines.next)

      val triangle1 = List(line1Values(0), line2Values(0), line3Values(0))
      val triangle2 = List(line1Values(1), line2Values(1), line3Values(1))
      val triangle3 = List(line1Values(2), line2Values(2), line3Values(2))

      columnSets = triangle1 :: triangle2 :: triangle3 :: columnSets
    }

    columnSets
  }
}
