package advent2016.day9

import advent2016.FileReader

/**
  * Created by campbell on 09-Dec-16.
  */
object ExperimentalCompression {

  case class Marker(index: Int, length: Int, repetition: Int)

  private val marker = """\((\d+)x(\d+)\).*""".r

  def getNextMarker(from: Int, input: String): Option[Marker] = input.indexOf('(', from) match {
    case index if index >= 0 => {
      input.substring(index) match {
        case marker(length, reps) => Option(Marker(index, length.toInt, reps.toInt))
        case _ => None
      }
    }
    case _ => None
  }

  def getMarkerSize(marker: Marker): Int = s"(${marker.length}x${marker.repetition})".length

  def applyMarker(input: String, marker: Marker): (String, Int) = {
    val markerSize = getMarkerSize(marker)
    val suffix = input.substring(marker.index + markerSize + marker.length)
    val prefix = input.substring(0, marker.index)

    val seq = input.substring(marker.index + markerSize).take(marker.length)
    var applied = ""
    for (rep <- 0 until marker.repetition) applied = applied + seq

    (s"$prefix$applied$suffix", marker.index + (marker.length * marker.repetition))
  }

  def decompress(input: String): String = {
    var decompressed = input
    var marker = getNextMarker(0, input)
    while (marker.isDefined) {
      val (current, index) = applyMarker(decompressed, marker.get)
      decompressed = current
      marker = getNextMarker(index, decompressed)
    }
    decompressed
  }

  def part1(inputFile: String): Unit = {
    val decompressed = decompress(FileReader.readFileByLine(inputFile).next())

    println(s"Part1: Decompressed length of file: ${decompressed.length}")
  }

  def continuousDecompress(input: String): String = {
    var decompressed = input

    while (getNextMarker(0, decompressed).isDefined) {
      decompressed = decompress(decompressed)
    }

    decompressed
  }

  def getDecompressedLength(input: String): Long = {
    def getLength(seq: String, reps: Int): Long = seq.matches("""\(\d+x\d\)[^\(]""") match {
      case true => continuousDecompress(seq).length * reps
      case false => getDecompressedLength(seq) * reps
    }

    var remaining = input
    var length: Long = 0
    var nextMarker = getNextMarker(0, remaining)
    while (nextMarker.isDefined) {
      length = length + nextMarker.get.index
      val size = getMarkerSize(nextMarker.get)
      length = length + getLength(remaining.substring(nextMarker.get.index + size, nextMarker.get.index + size + nextMarker.get.length), nextMarker.get.repetition)
      remaining = remaining.substring(nextMarker.get.index + size + nextMarker.get.length)
      nextMarker = getNextMarker(0, remaining)
    }

    length + remaining.length
  }

  def part2(inputFile: String): Unit = {
    val length = getDecompressedLength(FileReader.readFileByLine(inputFile).next())

    println(s"Part2: Repeated decompressed length of file: $length")
  }
}
