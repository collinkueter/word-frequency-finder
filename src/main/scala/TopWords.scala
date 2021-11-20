object TopWords {

  def topWords(frequencies: Map[String, Int], numberOfTopResults: Int): Seq[String] = {
    frequencies.toSeq.sortWith(_._2 > _._2).take(numberOfTopResults).map(_._1)
  }
}
