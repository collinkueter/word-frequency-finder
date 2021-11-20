object AppRunner extends App {

  private val words: Seq[String] = WordFetcher.fetch("https://www.gutenberg.org/files/2701/2701-0.txt")

  private val value: Map[String, Int] = CommonWordExcluder
    .exclude(words)
    .foldLeft(Map[String, Int]())((frequencies, word) => WordFrequencyCalculator.calculate(word, frequencies))

  println(TopWords.topWords(value, 50))
}
