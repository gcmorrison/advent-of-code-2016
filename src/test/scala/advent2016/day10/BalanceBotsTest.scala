package advent2016.day10

import org.scalatest.FunSuite
import advent2016.day10.BalanceBots._

/**
  * Created by campbell on 2016/12/12.
  */
class BalanceBotsTest extends FunSuite {

  test("Given a line with a pickup instruction, process into the correct case class") {
    assert(getInstructions("value 5 goes to bot 2") === List(PickUp(5, Bot(2))))
    assert(getInstructions("value 3 goes to bot 1") === List(PickUp(3, Bot(1))))
    assert(getInstructions("value 2 goes to bot 2") === List(PickUp(2, Bot(2))))
  }

  test("Given a line with a give instruction, process into the correct case classes") {
    assert(getInstructions("bot 2 gives low to bot 1 and high to bot 0") === List(GiveLow(Bot(2), Bot(1)), GiveHigh(Bot(2), Bot(0))))
    assert(getInstructions("bot 1 gives low to output 1 and high to bot 0") === List(GiveLow(Bot(1), Output(1)), GiveHigh(Bot(1), Bot(0))))
    assert(getInstructions("bot 0 gives low to output 2 and high to output 0") === List(GiveLow(Bot(0), Output(2)), GiveHigh(Bot(0), Output(0))))
  }

  test("Given a bot with a load, determine whether the bot should unload") {
    assert(isBotFull(buildFleet + (Bot(1) -> Nil), Bot(1)) === false)
    assert(isBotFull(buildFleet + (Bot(1) -> List(1)), Bot(1)) === false)
    assert(isBotFull(buildFleet + (Bot(1) -> List(1, 2)), Bot(1)) === true)
    assert(isBotFull(buildFleet + (Bot(1) -> List(1, 2, 3)), Bot(1)) === true)
  }

//  test("Given a fleet of drones and bins and a PickUp instruction, have the correct bot pick up the correct chip") {
//    val fleet = buildFleet
//    assert(applyInstructions(fleet, buildInstructions, List(PickUp(5, Bot(2)))).getOrElse(Bot(2), Nil) === List(5))
//    assert(fleet.getOrElse(Bot(5), Nil) === Nil)
//  }
//
//  test("Given a fleet of drones and bins and lists of instructions, apply all instructions") {
//    val fleet = applyInstructions(buildFleet, List(PickUp(5, Bot(2)), PickUp(2, Bot(2)), GiveLow(Bot(2), Bot(1)), GiveHigh(Bot(2), Bot(0))))
//    assert(fleet.getOrElse(Bot(2), List(1)) === Nil)
//    assert(fleet.getOrElse(Bot(1), Nil) === List(2))
//    assert(fleet.getOrElse(Bot(0), Nil) === List(5))
//  }

  private def buildFleet = Map[Target, List[Int]]()
  private def buildInstructions = Map[Target, List[Instruction]]()
}
