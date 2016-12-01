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
  }
}

object South extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => East
    case Right => West
  }
}

object East extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => North
    case Right => South
  }
}

object West extends Facing {
  def turn(turning: Turning): Facing = turning match {
    case Left => South
    case Right => North
  }
}
