package advent2016.day8

/**
  * Created by campbell on 2016/12/09.
  */
object TwoFactorAuth {
  def buildScreen(width: Int, height: Int) = Array.ofDim[Boolean](width, height)

  val parse = """([^\d ]+)([^\d]*)(\d+)([^\d]+)(\d+)""".r

  def getCommand(line: String): Command = line match {
    case parse("rect", _, wide, "x", tall) => Rect(wide.toInt, tall.toInt)
    case parse("rotate", rowCol, row, _, shift) if rowCol.contains("row") => RotateRow(row.toInt, shift.toInt)
    case parse("rotate", rowCol, col, _, shift) if rowCol.contains("column") => RotateCol(col.toInt, shift.toInt)
    case _ => Rect(-1, -1)
  }

  def part1(inputFile: String) = ???

}
