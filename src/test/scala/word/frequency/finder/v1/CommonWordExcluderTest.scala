package word.frequency.finder.v1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CommonWordExcluderTest extends AnyFlatSpec with Matchers {

  val commonWordsToExclude = Seq(
    "the",
    "of",
    "to",
    "and",
    "a",
    "in",
    "is",
    "it",
    "you",
    "that",
    "he",
    "was",
    "for",
    "on",
    "are",
    "with",
    "as",
    "I",
    "his",
    "they",
    "be",
    "at",
    "one",
    "have",
    "this",
    "from",
    "or",
    "had",
    "by",
    "not",
    "word",
    "but",
    "what",
    "some",
    "we",
    "can",
    "out",
    "other",
    "were",
    "all",
    "there",
    "when",
    "up",
    "use",
    "your",
    "how",
    "said",
    "an",
    "each",
    "she"
  )

  "exclude" should "remove common words" in {
    val words: Seq[String] = commonWordsToExclude :+ "bob"
    CommonWordExcluder.exclude(words) shouldBe Seq("bob")
  }

  it should "remove commons words case insensitive" in {
    val words = Seq("Bob", "The")
    CommonWordExcluder.exclude(words) shouldBe Seq("Bob")
  }
}
