package advent2016.day1

/**
  * Created by campbell on 2016/12/01.
  */
trait Facing {
  def turn(turning: Turning): Facing
}

object North extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => West
    case Right => East
    case Forward => this
  }
}

object South extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => East
    case Right => West
    case Forward => this
  }
}

object East extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => North
    case Right => South
    case Forward => this
  }
}

object West extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => South
    case Right => North
    case Forward => this
  }
}
