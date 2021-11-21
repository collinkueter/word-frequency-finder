package word.frequency.finder.v2

import cats.effect.{ExitCode, IO, IOApp}

object AppRunnerV2 extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    val numberOfTopResults = 50
    for {
      listOfTopWords <- WordFetcherV2
                          .fetch[IO]
                          .through(CommonWordExcluderV2.exclude)
                          .through(WordFrequencyCalculatorV2.calculate)
                          .through(TopWordsV2.n(numberOfTopResults))
                          .compile
                          .toList
      _              <- IO.println(listOfTopWords.head)
    } yield ExitCode.Success
  }
}
