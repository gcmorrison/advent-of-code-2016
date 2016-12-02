package advent2016.day1

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/01.
  */
class FacingTest extends FunSuite {
  test("When facing North and turning Left, I should now face West") {
    assert(North.turn(Left) === West)
  }

  test("When facing West and turning Left, I should now face South") {
    assert(West.turn(Left) === South)
  }

  test("When facing South and turning Left, I should now face East") {
    assert(South.turn(Left) === East)
  }

  test("When facing East and turning Left, I should now face North") {
    assert(East.turn(Left) === North)
  }

  test("When facing North and turning Right, I should now face East") {
    assert(North.turn(Right) === East)
  }

  test("When facing West and turning Right, I should now face South") {
    assert(East.turn(Right) === South)
  }

  test("When facing South and turning Right, I should now face East") {
    assert(South.turn(Right) === West)
  }

  test("When facing East and turning Right, I should now face North") {
    assert(West.turn(Right) === North)
  }

}
