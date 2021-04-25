package Algorithm

object WordSubset extends App {
  import scala.collection.mutable
  val subsetsCharsWithFreq = mutable.ListBuffer.empty[Map[Char, Int]]

  def wordSubsets(listString: Array[String], subSets: Array[String]): List[String] = {
    subSets foreach { subset =>
      subsetsCharsWithFreq.addOne(getCharsWithFreq(subset))
    }
    val containedSubset = mutable.ListBuffer.empty[String]

    listString foreach { str =>
      val charFrequency = getCharsWithFreq(str)
      if (isContainedSubset(charFrequency))
        containedSubset.addOne(str)
    }
    containedSubset.toList
  }

  def isContainedSubset(strCharWithFreq: Map[Char, Int]): Boolean = {
    var rs = true
    // each subset must valid
    subsetsCharsWithFreq foreach { charsWithFreq =>
      charsWithFreq foreach { charWithFreq =>
        val (char, freq) = charWithFreq
        val freqInString = strCharWithFreq.getOrElse(char, 0)
        if (freq > freqInString)
          rs = false
      }
    }
    rs
  }

  def getCharsWithFreq(str: String): Map[Char, Int] = {
    val charWithFrequency = mutable.Map.empty[Char, Int]
    for (char <- str) {
      charWithFrequency.get(char) match {
        case Some(appearance) =>
          charWithFrequency(char) = appearance + 1
        case _ => charWithFrequency += (char -> 1)
      }
    }
    charWithFrequency.toMap[Char, Int]
  }

  var inputA = Array("amazon","apple","facebook","google","leetcode")
  var inputB =  Array("e","o")
  var expected = Array("apple","google","leetcode")
  var rs = wordSubsets(inputA, inputB)
  println(s">> result: $rs")
}
