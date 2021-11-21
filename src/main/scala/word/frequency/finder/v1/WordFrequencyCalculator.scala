package word.frequency.finder.v1

object WordFrequencyCalculator {

  def calculate(word: String, frequencies: Map[String, Int]): Map[String, Int] = {
    val caseInsensitiveWord = word.toLowerCase
    if (frequencies.exists(_._1 == caseInsensitiveWord)) {
      val count: Int = frequencies(caseInsensitiveWord)
      frequencies + (caseInsensitiveWord -> (count + 1))
    } else {
      frequencies + (caseInsensitiveWord -> 1)
    }
  }

}
