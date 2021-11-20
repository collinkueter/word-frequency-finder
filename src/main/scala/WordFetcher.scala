import scala.io.{BufferedSource, Source}
import scala.util.Using

object WordFetcher {

  def fetch(url: String): Seq[String] = {
    Using
      .Manager { _ =>
        val source: BufferedSource = Source.fromURL(url)
        source
          .getLines()
          .flatMap(line => {
            line.replaceAll("\\p{C}", "").split(" ").toSeq.filterNot(_.isBlank).map(_.toLowerCase)
          })
          .toSeq
      }
      .getOrElse(Seq.empty)
  }

}
