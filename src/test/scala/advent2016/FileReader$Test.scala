package advent2016

import org.scalatest.FunSuite

/**
  * Created by campbell on 2016/11/23.
  */
class FileReader$Test extends FunSuite {

  test("Read file by line") {
    val lines = FileReader.readFileByLine("src/test/resources/testFile.txt")
    assert(lines.next === "Test file for IO implementation testing")
    assert(lines.next === "")
    assert(lines.next === "Hello World")
  }

  test("Read file by chars") {
    val chars = FileReader.readFileByChar("src/test/resources/testFile.txt")
    assert(chars.next === 'T')
    assert(chars.next === 'e')
    assert(chars.next === 's')
    assert(chars.next === 't')
  }
}
