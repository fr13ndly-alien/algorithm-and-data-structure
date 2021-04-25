package Algorithm

object CommonChars extends App {
  def commonChars(listString: Array[String]): List[String] = {
    val result = scala.collection.mutable.ListBuffer.empty[String]
    val charsWithFreq = scala.collection.mutable.Map.empty[String, Int]
    listString.mkString("").map { char =>
      val str = char.toString
      charsWithFreq.get(str) match {
        case None => charsWithFreq.addOne(str -> 1)
        case Some(freq) => charsWithFreq(str) = freq + 1
      }
    }

    charsWithFreq.foreach { charsWithFreq =>
      val (char, freq) = charsWithFreq
      if (freq > listString.length) {
        for (i <- 0 to (freq / listString.length))
          result.addOne(char)
      }
    }
    result.toList
  }

  var input = Array("bella","label","roller")
  var output = Array("e","l","l")
  println(s">> rs: ${commonChars(input).mkString("")} - [${output.mkString("")}]")

  input = Array("cool","lock","cook")
  output = Array("c", "o")
  println(s">> rs: ${commonChars(input).mkString("")} - [${output.mkString("")}]")

}
