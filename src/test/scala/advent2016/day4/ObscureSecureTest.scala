package advent2016.day4

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/05.
  */
class ObscureSecureTest extends FunSuite {

  test("A line must be expanded into its three components") {
    assert(ObscureSecure.expand("a-1[a]") === ("a", 1, "a"))
    assert(ObscureSecure.expand("ab-cd-12[kebab]") === ("abcd", 12, "kebab"))
    assert(ObscureSecure.expand("lkjdf-a-lkalk-sdjf-812[ollo]") === ("lkjdfalkalksdjf", 812, "ollo"))
  }

  test("Given an expanded tuple, sort encoding section by occurrence") {
    assert(ObscureSecure.reorganizeExpanded(("cbba", 2, "a")) === ("bac", 2, "a"))
    assert(ObscureSecure.reorganizeExpanded(("cba", 654, "cba")) === ("abc", 654, "cba"))
  }

  test("Given a string, order all unique characters by occurrence") {
    assert(ObscureSecure.orderUniqueCharsByOccurrence("aabadcb") === "abcd")
    assert(ObscureSecure.orderUniqueCharsByOccurrence("dfsdsaasdf") === "dsaf")
    assert(ObscureSecure.orderUniqueCharsByOccurrence("sdjkljsfljkds") === "jsdklf")
    assert(ObscureSecure.orderUniqueCharsByOccurrence("qrtyu") === "qrtuy")
  }

  test("Given a properly formatted encoding tuple, check if a given entry is valid") {
    assert(ObscureSecure.isValidSector(("a", 1, "a")) === true)
    assert(ObscureSecure.isValidSector(("ab", 1, "ba")) === false)
    assert(ObscureSecure.isValidSector(("abc", 1, "abc")) === true)
    assert(ObscureSecure.isValidSector(("abcdefglhad", 1, "abcde")) === true)
  }
}
