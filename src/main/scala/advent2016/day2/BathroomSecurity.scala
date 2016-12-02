package advent2016.day2

import advent2016.{Executor, FileReader}

/**
  * Created by campbell on 2016/12/02.
  */
object BathroomSecurity {
  private val starting: Int = 5

  def part1(inputFile: String): Unit = {
    print("Part1: The security code to the bathroom: ")
    stepOnKeyPad(inputFile)(effectOn3x3)
    println()
  }

  def part2(inputFile: String): Unit = {
    print("Part2: The security code to the bathroom: ")
    stepOnKeyPad(inputFile)(effectOnHex)
    println()
  }

  def stepOnKeyPad(inputFile: String)(effect: (Int, Char) => Int): Unit = {
    Executor.traverseAndTransform(FileReader.readFileByLine(inputFile), starting)((current, line) => {
      val endPoint = line.toIterator.foldLeft(current)((now, where) => now + effect(now, where))
      print(Integer.toHexString(endPoint))
      endPoint
    })
  }

  def effectOn3x3(current: Int, direction: Char): Int = (current, direction) match {
    case (top @ (1 | 2 | 3), _ @ 'U') => 0
    case (bottom @ (7 | 8 | 9), _ @ 'D') => 0
    case (left @ (1 | 4 | 7), _ @ 'L') => 0
    case (right @ (3 | 6 | 9), _ @ 'R') => 0
    case (other, _ @ 'U') => -3
    case (other, _ @ 'D') => 3
    case (other, _ @ 'L') => -1
    case (other, _ @ 'R') => 1
  }

  def effectOnHex(current: Int, direction: Char): Int = (current, direction) match {
    case (top @ (1 | 2 | 4 | 5 | 9), _ @ 'U') => 0
    case (bottom @ (5 | 9 | 0xA | 0xC | 0xD), _ @ 'D') => 0
    case (left @ (1 | 2 | 5 | 0xA | 0xD), _ @ 'L') => 0
    case (right @ (1 | 4 | 9 | 0xC | 0xD), _ @ 'R') => 0
    case (up @ (3 | 0xD), _ @ 'U') => -2
    case (down @ (1 | 0xB), _ @ 'D') => 2
    case (other, _ @ 'U') => -4
    case (other, _ @ 'D') => 4
    case (other, _ @ 'L') => -1
    case (other, _ @ 'R') => 1
  }
}
