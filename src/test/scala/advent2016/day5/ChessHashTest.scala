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
    assert(ChessHash.extractPasswordDigit("00000hello") === 'h')
    assert(ChessHash.extractPasswordDigit("000000world") === '0')
  }

  test("Given an input string and a counter, generate an MD5 hash") {
    assert(ChessHash.md5("hello", 1) === "203ad5ffa1d7c650ad681fdff3965cd2")
    assert(ChessHash.md5("hello", 10) === "75628fce248a7e55e27335a60900ebab")
    assert(ChessHash.md5("hello", 65468) === "00ca7b24a954b750aa02bd836a9b848c")
  }

  test("Given the provided inputs, we should get the expected outputs") {
    assert(ChessHash.findPassword("abc") === "18f47a30")
  }
}
