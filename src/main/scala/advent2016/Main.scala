package advent2016

import advent2016.day1.TaxiCab
import advent2016.day2.BathroomSecurity
import advent2016.day3.TriangleMath
import advent2016.day4.ObscureSecure
import advent2016.day5.ChessHash
import advent2016.day6.NoisySignals
import advent2016.day7.IPv7
import advent2016.day8.TwoFactorAuth

/**
  * Created by campbell on 2016/11/23.
  */
object Main extends App {
  val runAll = false
  val runLongChallenges = false

  if (runAll) {
    // Day1
    TaxiCab.part1("src/test/resources/day1/input1.txt")
    TaxiCab.part2("src/test/resources/day1/input1.txt")

    // Day2
    BathroomSecurity.part1("src/test/resources/day2/input1.txt")
    BathroomSecurity.part2("src/test/resources/day2/input1.txt")

    // Day3
    TriangleMath.part1("src/test/resources/day3/input1.txt")
    TriangleMath.part2("src/test/resources/day3/input1.txt")

    // Day4
    ObscureSecure.part1("src/test/resources/day4/input1.txt")
    ObscureSecure.part2("src/test/resources/day4/input1.txt")

    if (runLongChallenges) {
      // Day5: Too slow, must optimise!
      ChessHash.part1("ffykfhsq")
      ChessHash.part2("ffykfhsq")
    }

    // Day6
    NoisySignals.part1("src/test/resources/day6/input1.txt")
    NoisySignals.part2("src/test/resources/day6/input1.txt")

    // Day7
    IPv7.part1("src/test/resources/day7/input1.txt")
    IPv7.part2("src/test/resources/day7/input1.txt")
  }

  // Day8
  TwoFactorAuth.part1("src/test/resources/day8/input1.txt")
  TwoFactorAuth.part2("src/test/resources/day8/input1.txt")
}
