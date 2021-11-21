package word.frequency.finder.v2

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class WordFrequencyCalculatorV2Test extends AsyncFlatSpec with AsyncIOSpec with Matchers {
  it should "set frequency to 1 if word does not yet exist" in {
    fs2
      .Stream("bob", "bob", "harry")
      .through(WordFrequencyCalculatorV2.calculate[IO])
      .compile
      .toList
      .asserting(result => {
        result.head shouldBe Map("bob" -> 2, "harry" -> 1)
      })
  }

  it should "increase the frequency when word exists case insensitive" in {
    fs2
      .Stream("Bob", "bob")
      .through(WordFrequencyCalculatorV2.calculate[IO])
      .compile
      .toList
      .asserting(result => {
        result.head shouldBe Map("bob" -> 2)
      })
  }
}
