import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WordFrequencyCalculatorTest extends AnyFlatSpec with Matchers {

  it should "set frequency to 1 if word does not yet exist" in {
    val word        = "bob"
    val frequencies = Map("project" -> 1)
    WordFrequencyCalculator.calculate(word, frequencies) shouldBe Map("project" -> 1, "bob" -> 1)
  }

  it should "increase the frequency when word exists case insensitive" in {
    val word        = "Bob"
    val frequencies = Map("bob" -> 1)
    WordFrequencyCalculator.calculate(word, frequencies) shouldBe Map("bob" -> 2)
  }
}
