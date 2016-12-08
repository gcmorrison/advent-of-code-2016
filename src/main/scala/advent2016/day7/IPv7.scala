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

  def extractHypernets(input: String): (String, List[String]) = {
    def getNext(remaining: String, acc: (String, List[String])): (String, List[String]) = remaining.indexOf('[') match {
      case -1 => (s"${acc._1}$remaining".trim, acc._2)
      case from => {
        val to = remaining.indexOf(']')
        getNext(remaining.substring(to + 1), (s"${acc._1}${remaining.substring(0, from)} ", remaining.substring(from + 1, to) :: acc._2))
      }
    }

    getNext(input, ("", Nil))
  }

  def ipSupportsTls(ip: String): Boolean = {
    val separated = extractHypernets(ip)

    separated._2.filter(containsAbba).isEmpty && containsAbba(separated._1)
  }

  def part1(inputFile: String): Unit = {
    val tlsIps = FileReader.readFileByLine(inputFile).filter(ipSupportsTls)
    println(s"Part1: Number of IPv7s that support TLS: ${tlsIps.size}")
  }
}
