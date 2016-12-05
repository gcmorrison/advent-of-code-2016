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
      // TODO: Decrypt, then Filter
//      .map(decrypt)
      .toList

    println(s"Part2: Sector ID where North Pole objects are stored: ${result.head._2}")
  }

  def expand(input: String): (String, Int, String) = {
    val suffix = input.substring(input.lastIndexOf('-') + 1)

    val encoding = input.substring(0, input.length - suffix.length).replaceAll("-", "")
    val sectorId = suffix.substring(0, suffix.indexOf('[')).toInt
    val checksum = suffix.substring(suffix.indexOf('[') + 1, suffix.length - 1)

    (encoding, sectorId, checksum)
  }

  def reorganizeExpanded(expanded: (String, Int, String)): (String, Int, String) = {
    (orderUniqueCharsByOccurrence(expanded._1), expanded._2, expanded._3)
  }

  def orderUniqueCharsByOccurrence(input: String): String = {
    input.groupBy(char => char)
      .map(entry => (entry._1, entry._2.size))
      .toList
      .sortWith((left, right) => (left._2 > right._2) || (left._2 == right._2 && left._1 < right._1))
      .foldLeft("")((acc, value) => s"$acc${value._1}")
  }

  def isValidSector(encoding: (String, Int, String)): Boolean = encoding._1.take(5).equals(encoding._3)

//  def decryptCharacter(encrypted: Char, sectorId: Int): Char = encrypted match {
//    // TODO
//  }
//
//  def decrypt(encrypted: (String, Int, String)): (String, Int, String) = {
//    // TODO
//  }
}
