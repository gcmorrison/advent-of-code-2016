package advent2016.day8

/**
  * Created by campbell on 2016/12/09.
  */
trait Command

case class Rect(width: Int, height: Int) extends Command

case class RotateRow(row: Int, shiftCount: Int) extends Command

case class RotateCol(col: Int, shiftCount: Int) extends Command
