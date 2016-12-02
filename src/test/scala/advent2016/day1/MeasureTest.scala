package advent2016.day1
import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/01.
  */
class MeasureTest extends FunSuite{
  test("Measuring the distance between two points") {
    assert(Position(0, 0, North).distance(Position(2, 3, North)) === 5)
    assert(Position(0, 0, North).distance(Position(0, -2, North)) === 2)
    assert(Position(0, 0, North).distance(Position(10, 2, North)) === 12)
  }
}
