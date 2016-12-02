package advent2016.day1

/**
  * Created by campbell on 2016/12/01.
  */
case class Position(x: Int, y: Int, facing: Facing) {
  override def equals(that: Any): Boolean = that.isInstanceOf[Position] && distance(that.asInstanceOf[Position]) == 0

  override def hashCode(): Int = {
    val prime = 31
    val result = prime * 1 + x
    prime * result + y
  }

  def move(heading: Heading): Position = facing turn heading.turning match {
    case North => Position(x, y + heading.distance, North)
    case South => Position(x, y - heading.distance, South)
    case East => Position(x + heading.distance, y, East)
    case West => Position(x - heading.distance, y, West)
  }

  def distance(another: Position): Int = {
    Math.abs(x - another.x) + Math.abs(y - another.y)
  }

  def expandToSteps(destination: Position): Seq[Position] = {
    def accumulate(acc: Seq[Position]): Seq[Position] = {
      val newPosition = acc.head.move(Heading(Forward, 1))
      if (newPosition == destination) acc else accumulate(newPosition +: acc)
    }

    accumulate(Seq(Position(x, y, destination.facing)))
  }
}
