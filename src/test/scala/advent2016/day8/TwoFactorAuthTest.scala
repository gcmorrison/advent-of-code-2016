package advent2016.day8

import org.scalatest.FunSuite
import advent2016.day8.TwoFactorAuth._

/**
  * Created by campbell on 2016/12/09.
  */
class TwoFactorAuthTest extends FunSuite {

  test("Construct a screen with the given dimension") {
    assert(buildScreen(1, 1) === Array.ofDim[Boolean](1, 1))
    assert(buildScreen(8, 4) === Array.ofDim[Boolean](8, 4))
  }

  test("Given command string, extract the command and its parameters") {
    assert(getCommand("rect 1x2") === Rect(1, 2))
    assert(getCommand("rotate row y=5 by 3") === RotateRow(5, 3))
    assert(getCommand("rotate column x=15 by 30") === RotateCol(15, 30))
    assert(getCommand("rotate raw y=15 by 30") === Rect(-1, -1))
  }
}
