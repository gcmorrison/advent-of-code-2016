package advent2016.day1

/**
  * Created by campbell on 2016/12/01.
  */
object ProcessInstruction {
  def getHeading(instruction: String): Heading = {
    Heading(getTurning(instruction.charAt(0)), Integer.valueOf(instruction.substring(1)))
  }

  private def getTurning(instruction: Char): Turning = instruction match {
    case 'L' => Left
    case 'R' => Right
  }
}
