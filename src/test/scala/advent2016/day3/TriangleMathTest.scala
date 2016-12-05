package advent2016.day3

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/05.
  */
class TriangleMathTest extends FunSuite {
  test("A string containing three numbers should be parsed and processed correctly") {
    assert(TriangleMath.splitLineIntoSides("     1 2         3    ") === Array(1, 2, 3))
    assert(TriangleMath.splitLineIntoSides("123 321 678") === Array(123, 321, 678))
  }

  test("The sum of any two sides of a triangle should always be larger than the other") {
    assert(TriangleMath.isTriangle(1, 2, 2) === true)
    assert(TriangleMath.isTriangle(3, 2, 2) === true)
    assert(TriangleMath.isTriangle(1, 2, 20) === false)
    assert(TriangleMath.isTriangle(10, 2, 2) === false)
    assert(TriangleMath.isTriangle(1, 20, 2) === false)
  }

  test("Given a number of lines, triangles are defined as sets of 3 values in the same columns") {
    val testData = List("1 2 3", "4 5 6", "7 8 9")

    val result = TriangleMath.getTrianglesByColumn(testData.toIterator)
    assert(result(0) === List(1, 4, 7))
    assert(result(1) === List(2, 5, 8))
    assert(result(2) === List(3, 6, 9))
  }
}
