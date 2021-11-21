package word.frequency.finder.v2

import fs2.Pipe

object WordFrequencyCalculatorV2 {

  def calculate[F[_]]: Pipe[F, String, Map[String, Int]] = stream => {
    stream.fold(Map.empty[String, Int].withDefaultValue(0)) { case (counts, word) =>
      counts.updated(word.toLowerCase, counts(word) + 1)
    }
  }

}
