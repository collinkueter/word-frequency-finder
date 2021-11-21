package word.frequency.finder.v2

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class TopWordsV2Test extends AsyncFlatSpec with AsyncIOSpec with Matchers {
  "n" should "return list of top words using input parameter" in {
    fs2
      .Stream(Map("Bob" -> 2, "project" -> 8, "country" -> 3, "located" -> 1))
      .through(TopWordsV2.n[IO](2))
      .compile
      .toList
      .asserting(result => result.head shouldBe Seq("project", "country"))
  }
}
