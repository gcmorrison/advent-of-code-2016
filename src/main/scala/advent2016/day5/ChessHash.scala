package advent2016.day5

import java.math.BigInteger
import java.security.MessageDigest

/**
  * Created by Campbell on 2016/12/05.
  */
object ChessHash {
  val md5: MessageDigest = MessageDigest.getInstance("MD5")

  def isInterestingHash(hash: String): Boolean = hash.startsWith("00000")

  def extractPart1PasswordDigit(interestingHash: String): Char = interestingHash.charAt(5)

  def extractPart2PasswordDigit(interestingHash: String, currentPwd: String): String = interestingHash.charAt(5) match {
    case valid if '0' <= valid && valid <= '7' => {
      val position = Integer.valueOf(s"${valid}")
      if (currentPwd.charAt(position) == ' ')
        s"${currentPwd.substring(0, position)}${interestingHash.charAt(6)}${currentPwd.substring(position + 1)}"
      else currentPwd
    }
    case invalid => currentPwd
  }

  def hash(input: String, count: Int): String = {
    md5.digest(s"$input$count".getBytes("UTF-8"))
      .map("%02x" format _)
      .mkString
  }

  def findPasswordPart1(input: String): String = {
    Stream.from(0)
      .map(count => hash(input, count))
      .filter(isInterestingHash)
      .map(extractPart1PasswordDigit)
      .take(8)
      .mkString
  }

  def part1(input: String): Unit = {
    println(s"Part1: Password: ${findPasswordPart1(input)}")
  }

  def findPasswordPart2(input: String): String = {
    var password = "        "

    var count = 0
    while (password.contains(' ')) {
      val hashed = hash(input, count)
      password = if (isInterestingHash(hashed)) extractPart2PasswordDigit(hashed, password) else password
      count = count + 1
    }

    password
  }

  def part2(input: String): Unit = {
    println(s"Part2: Password: ${findPasswordPart2(input)}")
  }
}
