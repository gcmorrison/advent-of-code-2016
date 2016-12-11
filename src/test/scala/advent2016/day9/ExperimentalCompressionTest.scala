package advent2016.day9

import org.scalatest.FunSuite

import advent2016.day9.ExperimentalCompression._

/**
  * Created by campbell on 09-Dec-16.
  */
class ExperimentalCompressionTest extends FunSuite {

  test("Given a string with no markers, return the original string") {
    assert(decompress("hello world") === "hello world")
    assert(decompress("(ax3) world") === "(ax3) world")
    assert(decompress("hello (3xb) world") === "hello (3xb) world")
  }

  test("Given a string with a marker, return the index of the marker and the length and repetition of the sequence") {
    assert(getNextMarker(0, "hello world").isEmpty === true)
    assert(getNextMarker(5, "hello world").isEmpty === true)
    assert(getNextMarker(0, "he(1x2)lo wo(3x1)rld").get === Marker(2, 1, 2))
    assert(getNextMarker(2, "he(1x2)lo wo(3x1)rld").get === Marker(2, 1, 2))
    assert(getNextMarker(3, "he(1x2)lo wo(3x1)rld").get === Marker(12, 3, 1))
  }

  test("Given a marker, determine its size in characters") {
    assert(getMarkerSize(Marker(123321, 12, 34)) === "(12x34)".length)
    assert(getMarkerSize(Marker(123321, 1234, 3)) === "(1234x3)".length)
  }

  test("Given an input and a marker, replace the marker at the index and apply its effect") {
    assert(applyMarker("he(1x2)lo wo(3x1)rld", Marker(2, 1, 2)) === ("hello wo(3x1)rld", 4))
    assert(applyMarker("hello wo(3x1)rld", Marker(8, 3, 1)) === ("hello world", 11))
  }

  test("Given an input that contains markers, decompress the string accordingly") {
    assert(decompress("he(1x2)lo wo(3x1)rld") === "hello world")
  }

  test("Given an input that contains markers, determine its length without decompressing it") {
    assert(getDecompressedLength("he(1x2)lo wo(3x1)rld") === 11)
    assert(getDecompressedLength("x(8x2)(3x3)abcy") === 20)
    assert(getDecompressedLength("(27x12)(20x12)(13x14)(7x10)(1x12)A") === 241920)
    assert(getDecompressedLength("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN") === 445)
  }
}
