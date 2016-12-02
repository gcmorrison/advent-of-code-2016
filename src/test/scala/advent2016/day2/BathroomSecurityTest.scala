package advent2016.day2

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/02.
  */
class BathroomSecurityTest extends FunSuite {
  test("Given a 3x3 keypad, I must know how UP affects my value") {
    assert(BathroomSecurity.effectOn3x3(1, 'U') === 0)
    assert(BathroomSecurity.effectOn3x3(2, 'U') === 0)
    assert(BathroomSecurity.effectOn3x3(3, 'U') === 0)

    assert(BathroomSecurity.effectOn3x3(4, 'U') === -3)
    assert(BathroomSecurity.effectOn3x3(5, 'U') === -3)
    assert(BathroomSecurity.effectOn3x3(6, 'U') === -3)
    assert(BathroomSecurity.effectOn3x3(7, 'U') === -3)
    assert(BathroomSecurity.effectOn3x3(8, 'U') === -3)
    assert(BathroomSecurity.effectOn3x3(9, 'U') === -3)
  }
  
  test("Given a 3x3 keypad, I must know how DOWN affects my value") {
    assert(BathroomSecurity.effectOn3x3(1, 'D') === 3)
    assert(BathroomSecurity.effectOn3x3(2, 'D') === 3)
    assert(BathroomSecurity.effectOn3x3(3, 'D') === 3)
    assert(BathroomSecurity.effectOn3x3(4, 'D') === 3)
    assert(BathroomSecurity.effectOn3x3(5, 'D') === 3)
    assert(BathroomSecurity.effectOn3x3(6, 'D') === 3)

    assert(BathroomSecurity.effectOn3x3(7, 'D') === 0)
    assert(BathroomSecurity.effectOn3x3(8, 'D') === 0)
    assert(BathroomSecurity.effectOn3x3(9, 'D') === 0)
  }
  
  test("Given a 3x3 keypad, I must know how LEFT affects my value") {
    assert(BathroomSecurity.effectOn3x3(1, 'L') === 0)
    assert(BathroomSecurity.effectOn3x3(4, 'L') === 0)
    assert(BathroomSecurity.effectOn3x3(7, 'L') === 0)

    assert(BathroomSecurity.effectOn3x3(2, 'L') === -1)
    assert(BathroomSecurity.effectOn3x3(3, 'L') === -1)
    assert(BathroomSecurity.effectOn3x3(5, 'L') === -1)
    assert(BathroomSecurity.effectOn3x3(6, 'L') === -1)
    assert(BathroomSecurity.effectOn3x3(8, 'L') === -1)
    assert(BathroomSecurity.effectOn3x3(9, 'L') === -1)
  }
  
  test("Given a 3x3 keypad, I must know how RIGHT affects my value") {
    assert(BathroomSecurity.effectOn3x3(3, 'R') === 0)
    assert(BathroomSecurity.effectOn3x3(6, 'R') === 0)
    assert(BathroomSecurity.effectOn3x3(9, 'R') === 0)

    assert(BathroomSecurity.effectOn3x3(1, 'R') === 1)
    assert(BathroomSecurity.effectOn3x3(2, 'R') === 1)
    assert(BathroomSecurity.effectOn3x3(4, 'R') === 1)
    assert(BathroomSecurity.effectOn3x3(5, 'R') === 1)
    assert(BathroomSecurity.effectOn3x3(7, 'R') === 1)
    assert(BathroomSecurity.effectOn3x3(8, 'R') === 1)
  }
  
  test("Given a hex keypad, I must know how UP affects by value") {
    assert(BathroomSecurity.effectOnHex(1, 'U') === 0)
    assert(BathroomSecurity.effectOnHex(2, 'U') === 0)
    assert(BathroomSecurity.effectOnHex(3, 'U') === -2)
    assert(BathroomSecurity.effectOnHex(4, 'U') === 0)
    assert(BathroomSecurity.effectOnHex(5, 'U') === 0)
    assert(BathroomSecurity.effectOnHex(6, 'U') === -4)
    assert(BathroomSecurity.effectOnHex(7, 'U') === -4)
    assert(BathroomSecurity.effectOnHex(8, 'U') === -4)
    assert(BathroomSecurity.effectOnHex(9, 'U') === 0)
    assert(BathroomSecurity.effectOnHex(0xA, 'U') === -4)
    assert(BathroomSecurity.effectOnHex(0xB, 'U') === -4)
    assert(BathroomSecurity.effectOnHex(0xC, 'U') === -4)
    assert(BathroomSecurity.effectOnHex(0xD, 'U') === -2)
  }

  test("Given a hex keypad, I must know how DOWN affects by value") {
    assert(BathroomSecurity.effectOnHex(1, 'D') === 2)
    assert(BathroomSecurity.effectOnHex(2, 'D') === 4)
    assert(BathroomSecurity.effectOnHex(3, 'D') === 4)
    assert(BathroomSecurity.effectOnHex(4, 'D') === 4)
    assert(BathroomSecurity.effectOnHex(5, 'D') === 0)
    assert(BathroomSecurity.effectOnHex(6, 'D') === 4)
    assert(BathroomSecurity.effectOnHex(7, 'D') === 4)
    assert(BathroomSecurity.effectOnHex(8, 'D') === 4)
    assert(BathroomSecurity.effectOnHex(9, 'D') === 0)
    assert(BathroomSecurity.effectOnHex(0xA, 'D') === 0)
    assert(BathroomSecurity.effectOnHex(0xB, 'D') === 2)
    assert(BathroomSecurity.effectOnHex(0xC, 'D') === 0)
    assert(BathroomSecurity.effectOnHex(0xD, 'D') === 0)
  }
  
  test("Given a hex keypad, I must know how LEFT affects by value") {
    assert(BathroomSecurity.effectOnHex(1, 'L') === 0)
    assert(BathroomSecurity.effectOnHex(2, 'L') === 0)
    assert(BathroomSecurity.effectOnHex(3, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(4, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(5, 'L') === 0)
    assert(BathroomSecurity.effectOnHex(6, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(7, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(8, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(9, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(0xA, 'L') === 0)
    assert(BathroomSecurity.effectOnHex(0xB, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(0xC, 'L') === -1)
    assert(BathroomSecurity.effectOnHex(0xD, 'L') === 0)
  }

  test("Given a hex keypad, I must know how RIGHT affects by value") {
    assert(BathroomSecurity.effectOnHex(1, 'R') === 0)
    assert(BathroomSecurity.effectOnHex(2, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(3, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(4, 'R') === 0)
    assert(BathroomSecurity.effectOnHex(5, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(6, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(7, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(8, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(9, 'R') === 0)
    assert(BathroomSecurity.effectOnHex(0xA, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(0xB, 'R') === 1)
    assert(BathroomSecurity.effectOnHex(0xC, 'R') === 0)
    assert(BathroomSecurity.effectOnHex(0xD, 'R') === 0)
  }
}
