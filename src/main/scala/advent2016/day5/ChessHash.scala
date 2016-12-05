package advent2016.day5

import java.math.BigInteger
import java.security.MessageDigest

/**
  * Created by Campbell on 2016/12/05.
  */
object ChessHash {
  def isInterestingHash(hash: String): Boolean = hash.startsWith("00000")

  def extractPasswordDigit(interestingHash: String): Char = interestingHash.charAt(5)

  def md5(input: String, count: Int): String = {
    val md5 = MessageDigest.getInstance("MD5")
    md5.digest(s"$input$count".getBytes("UTF-8"))
      .map("%02x" format _)
      .mkString
  }

  def findPassword(input: String): String = {
    Stream.from(0)
      .map(count => md5(input, count))
      .filter(isInterestingHash)
      .map(extractPasswordDigit)
      .take(8)
      .mkString
  }

  def part1(input: String): Unit = {
    println(s"Part1: Password: ${findPassword(input)}")
  }

}
