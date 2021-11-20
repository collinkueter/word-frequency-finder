import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WordFetcherTest extends AnyFlatSpec with Matchers {

  "fetch" should "return list of words in lowercase" in {
    val result: Seq[String] = WordFetcher.fetch("https://www.gutenberg.org/files/2701/2701-0.txt")
    result.head shouldBe "the"
    result(1) shouldBe "project"
    result(2) shouldBe "gutenberg"
    result.length shouldBe 215864
  }

  it should "exclude non printable characters" in {
    val result: Seq[String] = WordFetcher.fetch("https://www.gutenberg.org/files/2701/2701-0.txt")
    result.head shouldBe "the"
  }

  it should "exclude empty strings" in {
    val result: Seq[String] = WordFetcher.fetch("https://www.gutenberg.org/files/2701/2701-0.txt")
    result(12) shouldBe "this"
  }
}
