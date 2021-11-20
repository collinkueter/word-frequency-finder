import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TopWordsTest extends AnyFlatSpec with Matchers {

  "topWords" should "return list of top words using input parameter" in {
    val frequencies = Map("Bob" -> 2, "project" -> 8, "country" -> 3, "located" -> 1)
    TopWords.topWords(frequencies, 2) shouldBe Seq("project", "country")
  }
}
