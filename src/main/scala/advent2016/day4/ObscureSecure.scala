package advent2016.day4

import advent2016.FileReader

/**
  * Created by campbell on 2016/12/05.
  */
object ObscureSecure {
  def part1(inputFile: String) = {
    val result = FileReader.readFileByLine(inputFile)
      .map(expand)
      .map(reorganizeExpanded)
      .filter(isValidSector)
      .map(valid => valid._2)

    println(s"Part1: Sum of all valid Sector IDs: ${result.sum}")
  }

  def part2(inputFile: String) = {
    val result = FileReader.readFileByLine(inputFile)
      .map(expand)
      .map(decrypt)
      .filter(p => p._1.equals("northpole object storage"))
      .next

    println(s"Part2: Sector ID where North Pole objects are stored: ${result._1} sectionId ${result._2}")
  }

  def expand(input: String): (String, Int, String) = {
    val suffix = input.substring(input.lastIndexOf('-') + 1)

    val encoding = input.substring(0, input.length - suffix.length - 1)
    val sectorId = suffix.substring(0, suffix.indexOf('[')).toInt
    val checksum = suffix.substring(suffix.indexOf('[') + 1, suffix.length - 1)

    (encoding, sectorId, checksum)
  }

  def reorganizeExpanded(expanded: (String, Int, String)): (String, Int, String) = {
    (orderUniqueCharsByOccurrence(expanded._1.replaceAll("-", "")), expanded._2, expanded._3)
  }

  def orderUniqueCharsByOccurrence(input: String): String = {
    input.groupBy(char => char)
      .map(entry => (entry._1, entry._2.size))
      .toList
      .sortWith((left, right) => (left._2 > right._2) || (left._2 == right._2 && left._1 < right._1))
      .foldLeft("")((acc, value) => s"$acc${value._1}")
  }

  def isValidSector(encoding: (String, Int, String)): Boolean = encoding._1.take(5).equals(encoding._3)

  def shiftChar(encrypted: Char, shiftTimes: Int): Char = encrypted match {
    case '-' => ' '
    case char => (((char % 'a') + shiftTimes) % 26 + 'a').toChar
  }

  def decrypt(encrypted: (String, Int, String)): (String, Int, String) = {
    (encrypted._1.toList.map(shiftChar(_, encrypted._2)).foldLeft("")((acc, value) => s"$acc$value"),
      encrypted._2, encrypted._3)
  }
}
