package word.frequency.finder.v1

import word.frequency.finder.CommonWords

object CommonWordExcluder {
  def exclude(words: Seq[String]): Seq[String] = {
    words.filterNot(word => CommonWords.words.map(_.toLowerCase).contains(word.toLowerCase))
  }
}
