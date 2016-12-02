package advent2016.day1

import advent2016.{Executor, FileReader}

/**
  * Created by campbell on 2016/12/01.
  */
object TaxiCab {
  val starting = Position(0, 0, North)
  val separator = ','

  def transform = (currentPosition: Position, nextInstruction: String) => currentPosition.move(ProcessInstruction.getHeading(nextInstruction))

  def part1(instructionsFile: String): Unit = {
    println(s"Part1: Distance to Easter Bunny HQ: ${starting.distance(followInstructionsFromFile(instructionsFile))}")
  }

  def followInstructionsFromFile(instructionsFile: String): Position = {
    travel(starting, FileReader.readFileByChar(instructionsFile))
  }

  def followInstructions(instructions: String): Position = {
    travel(starting, instructions.toIterator)
  }

  private def travel(start: Position, instructionsIterator: Iterator[Char]): Position = {
    Executor.traverseStringsBySeparatorAndTransform(instructionsIterator, separator, start)(transform)
  }

  def part2(instructionsFile: String): Unit = {
    println("Part2: Distance to Easter Bunny HQ: " +
      s"${starting.distance(findFirstDuplicate(FileReader.readFileByChar(instructionsFile)))}")
  }

  def findFirstDuplicate(instructionsIterator: Iterator[Char]): Position = {
    def accumulateUntilDuplicate(acc: Set[Position], current: Position): Position = {
      val newPosition = Executor.getNextAndTransform(instructionsIterator, separator, current)(transform)
      val movementAsSteps = current.expandToSteps(newPosition)
      val (newSet, duplicate) = addUntilDuplicate(acc, movementAsSteps)
      if (!duplicate.isEmpty) duplicate.get else accumulateUntilDuplicate(newSet, newPosition)
    }

    def addUntilDuplicate(currentPositions: Set[Position], steps: Seq[Position]): (Set[Position], Option[Position]) = {
      if (steps.isEmpty) (currentPositions, None)
      else {
        val newSet = currentPositions + steps.head
        if (currentPositions.size == newSet.size) (newSet, Option(steps.head))
        else addUntilDuplicate(newSet, steps.tail)
      }
    }

    accumulateUntilDuplicate(Set(), starting)
  }
}
