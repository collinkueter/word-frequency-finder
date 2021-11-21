package word.frequency.finder.v2

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers
import word.frequency.finder.CommonWords

class CommonWordExcluderV2Test extends AsyncFlatSpec with AsyncIOSpec with Matchers {

  "exclude" should "remove common words" in {
    fs2.Stream
      .emits(CommonWords.words :+ "bob")
      .through(CommonWordExcluderV2.exclude[IO])
      .compile
      .toList
      .asserting(result => {
        result shouldBe Seq("bob")
      })
  }

  it should "remove commons words case insensitive" in {
    fs2.Stream
      .emits(CommonWords.words :+ "Bob" :+ "The")
      .through(CommonWordExcluderV2.exclude[IO])
      .compile
      .toList
      .asserting(result => {
        result shouldBe Seq("Bob")
      })
  }
}
