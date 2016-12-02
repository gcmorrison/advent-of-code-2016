package advent2016

/**
  * Created by Campbell on 2016/12/01.
  */
object Executor {

  def traverseAndTransform[T, R](iterator: Iterator[T], current: R)
                                (transform: ((R, T) => R)): R = {
    if (iterator.hasNext) {
      traverseAndTransform(iterator, transform(current, iterator.next))(transform)
    } else {
      current
    }
  }

  def traverseStringsBySeparatorAndTransform[R](iterator: Iterator[Char], separator: Char, current: R)
                                               (transform: ((R, String) => R)): R = {
    if (iterator.hasNext) {
      val nextString = iterator.takeWhile(c => c != separator).foldLeft("")((acc, c) => s"$acc$c").trim
      traverseStringsBySeparatorAndTransform(iterator, separator, transform(current, nextString))(transform)
    } else {
      current
    }
  }

  def getNextAndTransform[R](iterator: Iterator[Char], separator: Char, current: R)
                            (transform: ((R, String) => R)): R = {
    if (iterator.hasNext) {
      val nextString = iterator.takeWhile(c => c != separator).foldLeft("")((acc, c) => s"$acc$c").trim
      transform(current, nextString)
    } else {
      current
    }
  }
}
