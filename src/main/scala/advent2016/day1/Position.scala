package advent2016.day1

/**
  * Created by campbell on 2016/12/01.
  */
case class Position(x: Int, y: Int, facing: Facing) {
  def move(heading: Heading): Position = facing turn heading.direction match {
    case North => Position(x, y + heading.distance, North)
    case South => Position(x, y - heading.distance, South)
    case East => Position(x + heading.distance, y, East)
    case West => Position(x - heading.distance, y, West)
  }

  def distance(another: Position): Int = {
    Math.abs(x - another.x) + Math.abs(y - another.y)
  }
}
