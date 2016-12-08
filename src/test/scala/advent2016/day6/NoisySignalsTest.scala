package advent2016.day6

import org.scalatest.FunSuite
import advent2016.day6.NoisySignals._

/**
  * Created by campbell on 2016/12/07.
  */
class NoisySignalsTest extends FunSuite {

  test("Given a string, expand it into a list of characters") {
    assert(explode("hello") === List("h", "e", "l", "l", "o"))
  }

  test("Given a list of charcters and a string, merge the exploded string into the list") {
    assert(merge(explode("hello"), "world") === List("hw", "eo", "lr", "ll", "od"))
    assert(merge(merge(explode("hello"), "world"), "today") === List("hwt", "eoo", "lrd", "lla", "ody"))
  }

  test("Given a string, find the most common character") {
    assert(mostCommon("hello world") === 'l')
  }

  test("Given a list of encoded messages, find the decoded message by most common character") {
    val input = List("eedadn",
      "drvtee",
      "eandsr",
      "raavrd",
      "atevrs",
      "tsrnev",
      "sdttsa",
      "rasrtv",
      "nssdts",
      "ntnada",
      "svetve",
      "tesnvt",
      "vntsnd",
      "vrdear",
      "dvrsen",
      "enarar")
    assert(decode(input.toIterator)(mostCommon) === "easter")
  }

  test("Given a list of encoded messages, find the decoded message by least common character") {
    val input = List("eedadn",
      "drvtee",
      "eandsr",
      "raavrd",
      "atevrs",
      "tsrnev",
      "sdttsa",
      "rasrtv",
      "nssdts",
      "ntnada",
      "svetve",
      "tesnvt",
      "vntsnd",
      "vrdear",
      "dvrsen",
      "enarar")
    assert(decode(input.toIterator)(leastCommon) === "advent")
  }
}
