package advent2016

import advent2016.day1.TaxiCab
import advent2016.day2.BathroomSecurity
import advent2016.day3.TriangleMath

/**
  * Created by campbell on 2016/11/23.
  */
object Main extends App {
  // Day1
  TaxiCab.part1("src/test/resources/day1/input1.txt")
  TaxiCab.part2("src/test/resources/day1/input1.txt")

  // Day2
  BathroomSecurity.part1("src/test/resources/day2/input1.txt")
  BathroomSecurity.part2("src/test/resources/day2/input1.txt")

  // Day3
  TriangleMath.part1("src/test/resources/day3/input1.txt")
  TriangleMath.part2("src/test/resources/day3/input1.txt")
}
