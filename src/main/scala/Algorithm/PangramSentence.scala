package Algorithm

object PangramSentence extends App {
  def checkIfPangram(sentence: String): Boolean = {
    val charSet = sentence.distinct
    charSet.length == 26
  }

  checkIfPangram("thequickbrownfoxjumpsoverthelazydog")
}
