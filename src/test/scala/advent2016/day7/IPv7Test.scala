package advent2016.day7

import org.scalatest.FunSuite
import advent2016.day7.IPv7._

/**
  * Created by campbell on 2016/12/08.
  */
class IPv7Test extends FunSuite {

  test("Given a 4 character string, determine whether string is a palindrome, but not all the same characters") {
    assert(isAbba("aba") === false)
    assert(isAbba("abb") === false)
    assert(isAbba("abcd") === false)
    assert(isAbba("abca") === false)
    assert(isAbba("abba") === true)
    assert(isAbba("dddd") === false)
  }

  test("Given a long string, determine whether it contains any ABBAs") {
    assert(containsAbba("helloworld") === false)
    assert(containsAbba("holloworld") === true)
    assert(containsAbba("helloworro") === true)
  }

  test("Given a string containing hypernet sequences, extract all hypernet sequences into list") {
    assert(extractHypernets("helloworld") === ("helloworld", ""))
    assert(extractHypernets("hel[low]orld") === ("hel orld", "low"))
    assert(extractHypernets("h[ello]w[orl]d") === ("h w d", "ello orl"))
    assert(extractHypernets("[hell]owo[rld]") === ("owo", "hell rld"))
  }

  test("Given an ipv7, determine whether it supports TLS") {
    assert(ipSupportsTls("abba[mnop]qrst") === true)
    assert(ipSupportsTls("abcd[bddb]xyyx") === false)
    assert(ipSupportsTls("aaaa[qwer]tyui") === false)
    assert(ipSupportsTls("ioxxoj[asdfgh]zxcvbn") === true)
  }

  test("Given a 3 character string, determine whether string is a palindrome, but not all the same characters") {
    assert(isAba("abb") === false)
    assert(isAba("abc") === false)
    assert(isAba("aab") === false)
    assert(isAba("aba") === true)
    assert(isAba("ddd") === false)
  }

  test("Given a long string, extract all Abas") {
    assert(extractAbas("abacdc") === List("cdc", "aba"))
  }

  test("Given an ABA, convert the string to a BAB") {
    assert(convertToBab("aba") === "bab")
    assert(convertToBab("xyx") === "yxy")
    assert(convertToBab("dex") === "ede")
  }

  test("Given an ABA and hypernet sequences, determine whether ip supports SSL") {
    assert(ipSupportsSSL("aba[bab]xyz") === true)
    assert(ipSupportsSSL("xyx[xyx]xyx") === false)
    assert(ipSupportsSSL("aaa[kek]eke") === true)
    assert(ipSupportsSSL("zazbz[bzb]cdb") === true)
  }
}
