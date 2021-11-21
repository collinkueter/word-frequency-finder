package word.frequency.finder.v2

import fs2.Pipe
import word.frequency.finder.CommonWords

object CommonWordExcluderV2 {

  def exclude[F[_]]: Pipe[F, String, String] =
    _.filter(word => !CommonWords.words.map(_.toLowerCase).contains(word.toLowerCase))

}
