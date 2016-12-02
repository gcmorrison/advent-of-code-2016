package advent2016.day1

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/12/01.
  */
class TaxiCabTest extends FunSuite {
  test("TaxiCab with instructions should follow directions correctly, no detours!") {
    assert(TaxiCab.starting.distance(TaxiCab.followInstructions("R2, L3")) === 5)
    assert(TaxiCab.starting.distance(TaxiCab.followInstructions("R2, R2, R2")) === 2)
    assert(TaxiCab.starting.distance(TaxiCab.followInstructions("R5, L5, R5, R3")) === 12)
  }

  test("TaxiCab with instructions should find the first duplicate position") {
    assert(TaxiCab.starting.distance(TaxiCab.findFirstDuplicate("R8, R4, R4, R8".toIterator)) === 4)
  }
}
