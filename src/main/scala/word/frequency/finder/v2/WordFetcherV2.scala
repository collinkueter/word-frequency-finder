package word.frequency.finder.v2

import cats.effect.kernel.Async
import cats.implicits.catsSyntaxApplicativeId
import fs2.{Pipe, io, text}

import java.net.URL

object WordFetcherV2 {

  def fetch[F[_] : Async]: fs2.Stream[F, String] =
    io.readInputStream[F](
      new URL("https://www.gutenberg.org/files/2701/2701-0.txt").openConnection.getInputStream.pure[F],
      4096
    ).through(text.utf8.decode)
      .through(text.lines)
      .through(splitIntoWords)

  private def splitIntoWords[F[_]]: Pipe[F, String, String] =
    _.flatMap(line => fs2.Stream(line.split("\\W+"): _*)).filter(!_.isBlank)

}
