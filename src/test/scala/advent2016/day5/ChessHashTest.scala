package advent2016.day5

import org.scalatest.FunSuite

/**
  * Created by Campbell on 2016/12/05.
  */
class ChessHashTest extends FunSuite {
  test("Identify whether a given hash is an interesting hash") {
    assert(ChessHash.isInterestingHash("") === false)
    assert(ChessHash.isInterestingHash("ab") === false)
    assert(ChessHash.isInterestingHash("0000hello") === false)
    assert(ChessHash.isInterestingHash("00000hello") === true)
    assert(ChessHash.isInterestingHash("0000000000hello") === true)
  }

  test("Given an interesting hash, extract the password digit") {
    assert(ChessHash.extractPart1PasswordDigit("00000hello") === 'h')
    assert(ChessHash.extractPart1PasswordDigit("000000world") === '0')
  }

  test("Given an input string and a counter, generate an MD5 hash") {
    assert(ChessHash.hash("hello", 1) === "203ad5ffa1d7c650ad681fdff3965cd2")
    assert(ChessHash.hash("hello", 10) === "75628fce248a7e55e27335a60900ebab")
    assert(ChessHash.hash("hello", 65468) === "00ca7b24a954b750aa02bd836a9b848c")
  }

  test("Given the provided inputs, we should get the expected outputs for Part1") {
    assert(ChessHash.findPasswordPart1("abc") === "18f47a30")
  }

  test("Given the provided inputs, we should get the expected outputs for Part2") {
    assert(ChessHash.findPasswordPart2("abc") === "05ace8e3")
  }

  test("Given an interesting hash and a password string, extract the correct character from the hash and add to the password in the right position") {
    assert(ChessHash.extractPart2PasswordDigit("0000012", "        ") === " 2      ")
    assert(ChessHash.extractPart2PasswordDigit("0000000", "        ") === "0       ")
    assert(ChessHash.extractPart2PasswordDigit("0000049", "        ") === "    9   ")
    assert(ChessHash.extractPart2PasswordDigit("000007F", "        ") === "       F")
    assert(ChessHash.extractPart2PasswordDigit("0000049", "12345678") === "12345678")
    assert(ChessHash.extractPart2PasswordDigit("0000089", "12345678") === "12345678")
  }
}
