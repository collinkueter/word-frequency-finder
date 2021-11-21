package word.frequency.finder.v2

import cats.effect.IO
import cats.effect.testing.scalatest.AsyncIOSpec
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class WordFetcherV2Test extends AsyncFlatSpec with AsyncIOSpec with Matchers {

  "fetch" should "return list of words in lowercase" in {
    WordFetcherV2
      .fetch[IO]
      .compile
      .toList
      .asserting(result => {
        result.head shouldBe "The"
        result(1) shouldBe "Project"
        result(2) shouldBe "Gutenberg"
        result.length shouldBe 222724
      })
  }

  it should "exclude empty strings" in {
    WordFetcherV2
      .fetch[IO]
      .compile
      .toList
      .asserting(result => {
        result(13) shouldBe "This"
      })
  }
}
