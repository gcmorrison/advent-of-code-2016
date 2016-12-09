package advent2016.day7

import advent2016.FileReader

/**
  * Created by campbell on 2016/12/08.
  */
object IPv7 {

  def isAbba(input: String): Boolean = input.length == 4 && input.contentEquals(input.reverse) && input(0) != input(1)

  def containsAbba(input: String): Boolean =
    if (input.length <= 4) isAbba(input)
    else isAbba(input.substring(0, 4)) || containsAbba(input.substring(1))

  def extractHypernets(input: String): (String, String) = {
    def getNext(remaining: String, acc: (String, String)): (String, String) = remaining.indexOf('[') match {
      case -1 => (s"${acc._1}$remaining".trim, acc._2.trim)
      case from => {
        val to = remaining.indexOf(']')
        getNext(remaining.substring(to + 1), (s"${acc._1}${remaining.substring(0, from)} ", s"${acc._2} ${remaining.substring(from + 1, to)}"))
      }
    }

    getNext(input, ("", ""))
  }

  def ipSupportsTls(ip: String): Boolean = {
    val separated = extractHypernets(ip)

    !containsAbba(separated._2) && containsAbba(separated._1)
  }

  def isAba(input: String): Boolean = input.length == 3 && input.contentEquals(input.reverse) && input(0) != input(1)

  def extractAbas(input: String): List[String] = {
    def getNext(test: String, remaining: String, acc: List[String]): List[String] = {
      val updated = if (isAba(test)) test :: acc else acc

      if (remaining.length < 3) updated
      else getNext(remaining.substring(0, 3), remaining.substring(1), updated)
    }

    getNext(input.substring(0, 3), input.substring(1), Nil)
  }

  def convertToBab(aba: String): String = s"${aba(1)}${aba(0)}${aba(1)}"

  def containsBab(bab: String, input: String): Boolean = input.contains(bab)

  def ipSupportsSSL(ip: String): Boolean = {
    val separated = extractHypernets(ip)

    extractAbas(separated._1)
        .map(convertToBab)
      .filter(containsBab(_, separated._2))
      .nonEmpty
  }

  def part1(inputFile: String): Unit = {
    val tlsIps = FileReader.readFileByLine(inputFile).filter(ipSupportsTls)
    println(s"Part1: Number of IPv7s that support TLS: ${tlsIps.size}")
  }

  def part2(inputFile: String): Unit = {
    val sslIps = FileReader.readFileByLine(inputFile).filter(ipSupportsSSL)
    println(s"Part2: Number of IPv7s that support SSL: ${sslIps.size}")
  }
}
