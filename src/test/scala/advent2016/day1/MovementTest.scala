package advent2016.day1

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/01.
  */
class MovementTest extends FunSuite {
  test("When facing North and moving 5 positions Left, I should end 5 positions West of my starting position and facing West") {
    assert(Position(0, 0, North).move(Heading(Left, 5)) === Position(-5, 0, West))
    assert(Position(10, 5, North).move(Heading(Left, 5)) === Position(5, 5, West))
  }

  test("When facing West and moving 5 positions Left, I should end 5 positions South of my starting position and facing West") {
    assert(Position(0, 0, West).move(Heading(Left, 5)) === Position(0, -5, South))
    assert(Position(5, 10, West).move(Heading(Left, 5)) === Position(5, 5, South))
  }

  test("When facing South and moving 5 positions Left, I should end 5 positions East of my starting position and facing East") {
    assert(Position(0, 0, South).move(Heading(Left, 5)) === Position(5, 0, East))
    assert(Position(5, 10, South).move(Heading(Left, 5)) === Position(10, 10, East))
  }

  test("When facing East and moving 5 positions Left, I should end 5 positions South of my starting position and facing South") {
    assert(Position(0, 0, East).move(Heading(Left, 5)) === Position(0, 5, North))
    assert(Position(5, 10, East).move(Heading(Left, 5)) === Position(5, 15, North))
  }

  test("When facing North and moving 5 positions Right, I should end 5 positions East of my starting position and facing East") {
    assert(Position(0, 0, North).move(Heading(Right, 5)) === Position(5, 0, East))
    assert(Position(10, 5, North).move(Heading(Right, 5)) === Position(15, 5, East))
  }

  test("When facing West and moving 5 positions Right, I should end 5 positions North of my starting position and facing North") {
    assert(Position(0, 0, West).move(Heading(Right, 5)) === Position(0, 5, North))
    assert(Position(5, 10, West).move(Heading(Right, 5)) === Position(5, 15, North))
  }

  test("When facing South and moving 5 positions Right, I should end 5 positions West of my starting position and facing West") {
    assert(Position(0, 0, South).move(Heading(Right, 5)) === Position(-5, 0, West))
    assert(Position(5, 10, South).move(Heading(Right, 5)) === Position(0, 10, West))
  }

  test("When facing East and moving 5 positions Right, I should end 5 positions South of my starting position and facing South") {
    assert(Position(0, 0, East).move(Heading(Right, 5)) === Position(0, -5, South))
    assert(Position(5, 10, East).move(Heading(Right, 5)) === Position(5, 5, South))
  }

}
