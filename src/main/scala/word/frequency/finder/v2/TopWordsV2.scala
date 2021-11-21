package word.frequency.finder.v2

import fs2.Pipe

object TopWordsV2 {

  def n[F[_]](numberOfTopResults: Int): Pipe[F, Map[String, Int], Seq[String]] =
    _.map((r: Map[String, Int]) => r.toSeq.sortWith(_._2 > _._2).take(numberOfTopResults).map(_._1))
}
