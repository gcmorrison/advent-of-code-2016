package advent2016.day8

import advent2016.day8.TwoFactorAuth._
import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/09.
  */
class TwoFactorAuthTest extends FunSuite {

  private val $ = true
  private val * = false

  test("Construct a screen with the given dimension") {
    assert(buildScreen(1, 1) === Array.ofDim[Boolean](1, 1))
    assert(buildScreen(8, 4) === Array.ofDim[Boolean](4, 8))
  }

  test("Given command string, extract the command and its parameters") {
    assert(getCommand("rect 1x2") === Rect(1, 2))
    assert(getCommand("rotate row y=5 by 3") === RotateRow(5, 3))
    assert(getCommand("rotate column x=15 by 30") === RotateCol(15, 30))
    assert(getCommand("rotate raw y=15 by 30") === Rect(-1, -1))
  }

  test("Given a screen and a Rect command, draw the rectangle in the top left") {
    assert(drawRect(buildScreen(3, 4), Rect(1, 1), (0, 0)) ===
      Array(
        Array($, *, *),
        Array(*, *, *),
        Array(*, *, *),
        Array(*, *, *)))

    assert(drawRect(buildScreen(3, 4), Rect(2, 2), (1, 2)) ===
      Array(
        Array(*, *, *),
        Array(*, *, *),
        Array(*, $, $),
        Array(*, $, $)))

    assert(drawRect(buildScreen(3, 4), Rect(2, 1), (1, 1)) ===
      Array(
        Array(*, *, *),
        Array(*, $, $),
        Array(*, *, *),
        Array(*, *, *)))

    assert(drawRect(buildScreen(3, 4), Rect(2, 2), (2, 3)) ===
      Array(
        Array($, *, $),
        Array(*, *, *),
        Array(*, *, *),
        Array($, *, $)))
  }

  test("Given a screen and a RotateCol command, shift all the content in the given column down") {
    def screen = drawRect(buildScreen(4, 3), Rect(2, 1), (1, 1))
    assert(screen ===
      Array(
        Array(*, *, *, *),
        Array(*, $, $, *),
        Array(*, *, *, *)))

    assert(drawRotateCol(screen, RotateCol(1, 1)) ===
      Array(
        Array(*, *, *, *),
        Array(*, *, $, *),
        Array(*, $, *, *)))

    assert(drawRotateCol(screen, RotateCol(2, 2)) ===
      Array(
        Array(*, *, $, *),
        Array(*, $, *, *),
        Array(*, *, *, *)))

    assert(drawRotateCol(screen, RotateCol(2, 3)) ===
      Array(
        Array(*, *, *, *),
        Array(*, $, $, *),
        Array(*, *, *, *)))
  }

  test("Given a screen and a RotateRow command, shift all the content in the given row left") {
    def screen = drawRect(buildScreen(3, 4), Rect(1, 2), (1, 1))
    assert(screen ===
      Array(
        Array(*, *, *),
        Array(*, $, *),
        Array(*, $, *),
        Array(*, *, *)))

    assert(drawRotateRow(screen, RotateRow(1, 1)) ===
      Array(
        Array(*, *, *),
        Array(*, *, $),
        Array(*, $, *),
        Array(*, *, *)))

    assert(drawRotateRow(screen, RotateRow(2, 2)) ===
      Array(
        Array(*, *, *),
        Array(*, $, *),
        Array($, *, *),
        Array(*, *, *)))

    assert(drawRotateRow(screen, RotateRow(2, 3)) ===
      Array(
        Array(*, *, *),
        Array(*, $, *),
        Array(*, $, *),
        Array(*, *, *)))
  }

  test("Given a screen and a command, the screen gets updated accordingly") {
    val step1 = applyCommand(buildScreen(7, 3), Rect(3, 2))
    assert(step1 ===
      Array(
        Array($, $, $, *, *, *, *),
        Array($, $, $, *, *, *, *),
        Array(*, *, *, *, *, *, *)))

    val step2 = applyCommand(step1, RotateCol(1, 1))
    assert(step2 ===
      Array(
        Array($, *, $, *, *, *, *),
        Array($, $, $, *, *, *, *),
        Array(*, $, *, *, *, *, *)))

    val step3 = applyCommand(step2, RotateRow(0, 4))
    assert(step3 ===
      Array(
        Array(*, *, *, *, $, *, $),
        Array($, $, $, *, *, *, *),
        Array(*, $, *, *, *, *, *)))

    val step4 = applyCommand(step3, RotateCol(1, 1))
    assert(step4 ===
      Array(
        Array(*, $, *, *, $, *, $),
        Array($, *, $, *, *, *, *),
        Array(*, $, *, *, *, *, *)))
  }

  test("Given a screen, create a human readable representation of it") {
    assert(printScreen(Array(
      Array(*, $, *, *, $, *, $),
      Array($, *, $, *, *, *, *),
      Array(*, $, *, *, *, *, *))) === ".#..#.#\n#.#....\n.#.....")
  }
}
