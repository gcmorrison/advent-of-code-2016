package advent2016.day8

import advent2016.FileReader

/**
  * Created by campbell on 2016/12/09.
  */
object TwoFactorAuth {
  type Screen = Array[Array[Boolean]]

  trait Command

  case class Rect(width: Int, height: Int) extends Command

  case class RotateRow(id: Int, shift: Int) extends Command

  case class RotateCol(id: Int, shift: Int) extends Command

  def buildScreen(width: Int, height: Int): Screen = Array.ofDim[Boolean](height, width)

  val parse = """([^\d ]+) ([(row)(column)]*)([^\d]*)(\d+)([^\d]+)(\d+)""".r

  def getCommand(line: String): Command = line match {
    case parse("rect", _, _, wide, "x", high) => Rect(wide.toInt, high.toInt)
    case parse("rotate", "row", _, id, _, shift) => RotateRow(id.toInt, shift.toInt)
    case parse("rotate", "column", _, id, _, shift) => RotateCol(id.toInt, shift.toInt)
    case _ => Rect(-1, -1)
  }

  def applyCommand(screen: Screen, command: Command): Screen = command match {
    case cmd@Rect(_, _) => drawRect(screen, cmd, (0, 0))
    case cmd@RotateCol(_, _) => drawRotateCol(screen, cmd)
    case cmd@RotateRow(_, _) => drawRotateRow(screen, cmd)
  }

  def drawRect(screen: Screen, rect: Rect, pos: (Int, Int)): Screen = {
    val redraw = screen.clone()
    for {
      x <- pos._1 until pos._1 + rect.width
      y <- pos._2 until pos._2 + rect.height
    } {
      redraw(y % screen.length)(x % screen(0).length) = true
    }
    redraw
  }

  def drawRotateCol(screen: Screen, column: RotateCol): Screen = {
    def shift(redraw: Screen, prev: Boolean, index: Int): Unit = {
      if (index == redraw.length - 1) redraw(index)(column.id) = prev
      else {
        shift(redraw, redraw(index)(column.id), index + 1)
        redraw(index)(column.id) = prev
      }
    }

    val redraw = screen.clone()

    for (_ <- 0 until column.shift) {
      val last = redraw(redraw.length - 1)(column.id)
      shift(redraw, redraw(0)(column.id), 0)
      redraw(0)(column.id) = last
    }

    redraw
  }

  def drawRotateRow(screen: Screen, row: RotateRow): Screen = {
    def shift(redraw: Screen, prev: Boolean, index: Int): Unit = {
      if (index == redraw(0).length - 1) redraw(row.id)(index) = prev
      else {
        shift(redraw, redraw(row.id)(index), index + 1)
        redraw(row.id)(index) = prev
      }
    }

    val redraw = screen.clone()

    for (_ <- 0 until row.shift) {
      val last = redraw(row.id)(redraw(0).length - 1)
      shift(redraw, redraw(row.id)(0), 0)
      redraw(row.id)(0) = last
    }

    redraw
  }

  def printScreen(screen: Screen): String = {
    screen.map(line => line.map(flag => if (flag) "#" else ".") mkString "") mkString "\n"
  }

  def part1(inputFile: String): Unit = {
    val screen = buildScreen(50, 6)

    FileReader.readFileByLine(inputFile)
      .foreach(line => applyCommand(screen, getCommand(line)))

    println(s"Part1: Number of pixels lit after all commands: ${screen.map(line => line.map(lit => if (lit) 1 else 0).sum).sum}")
  }

  def part2(inputFile: String): Unit = {
    val screen = buildScreen(50, 6)

    FileReader.readFileByLine(inputFile)
      .foreach(line => applyCommand(screen, getCommand(line)))

    // I know I cheated and just manually read it.  Ain't nobody got time for OCR
    println(s"Part2: Content of screen after all commands:\n${printScreen(screen)}")
  }
}
