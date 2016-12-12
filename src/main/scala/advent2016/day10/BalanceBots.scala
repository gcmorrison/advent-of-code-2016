package advent2016.day10

import advent2016.FileReader

/**
  * Created by campbell on 2016/12/12.
  */
object BalanceBots {

  trait Instruction

  case class PickUp(chip: Int, bot: Target) extends Instruction

  case class GiveLow(from: Target, to: Target) extends Instruction

  case class GiveHigh(from: Target, to: Target) extends Instruction

  trait Target

  case class Bot(id: Int) extends Target

  case class Output(id: Int) extends Target

  private val pickUpInstruction = """^value (\d+) goes to bot (\d+)$""".r
  private val giveInstruction = """^bot (\d+) gives low to (\D+) (\d+) and high to (\D+) (\d+)$""".r

  def getTarget(target: String, id: Int): Target = target match {
    case "bot" => Bot(id)
    case "output" => Output(id)
  }

  def getInstructions(input: String): List[Instruction] = input match {
    case pickUpInstruction(chip, bot) => List(PickUp(chip.toInt, Bot(bot.toInt)))
    case giveInstruction(fromBot, lowTarget, lowId, highTarget, highId) => List(
      GiveLow(Bot(fromBot.toInt), getTarget(lowTarget, lowId.toInt)),
      GiveHigh(Bot(fromBot.toInt), getTarget(highTarget, highId.toInt))
    )
  }

  def isBotFull(loadSet: Map[Target, List[Int]], target: Target): Boolean = loadSet.getOrElse(target, Nil).size >= 2

  var loadSet: Map[Target, List[Int]] = Map()
  var instructionSet: Map[Target, List[Instruction]] = Map()

  def applyInstructions(instructions: List[Instruction]): Unit = {
    def applyInstr(instruction: Instruction): Unit = instruction match {
      case PickUp(chip, bot) => {
        loadSet = loadSet + (bot -> (chip :: loadSet.getOrElse(bot, List[Int]())))
        if (isBotFull(loadSet, bot)) applyInstructions(instructionSet(bot))
      }
      case GiveLow(from, to) => instructionSet = instructionSet + (from -> (GiveLow(from, to) :: instructionSet.getOrElse(from, List[Instruction]())))
      case GiveHigh(from, to) => instructionSet = instructionSet + (from -> (GiveHigh(from, to) :: instructionSet.getOrElse(from, List[Instruction]())))
    }

    // TODO: Determine if expected match is found
    if (instructions.nonEmpty) {
      applyInstr(instructions.head)
      applyInstructions(instructions.tail)
    }
  }

  def part1(inputFile: String): Unit = {
    applyInstructions(FileReader.readFileByLine(inputFile)
      .map(instr => getInstructions(instr))
      .toList
      .reverse
      .flatten)

    println("What?")
    //    val updatedFleet = applyInstructions(Map[Target, List[Int]](), instructions)
  }
}
