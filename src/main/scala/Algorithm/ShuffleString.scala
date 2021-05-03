package Algorithm

// https://leetcode.com/problems/shuffle-string/
object ShuffleString extends App {

  def restoreString(s: String, indices: Array[Int]): String = {
    val map = scala.collection.mutable.Map.empty[Int, Char]
    (0 until s.length) foreach (index => map += (indices(index) -> s.charAt(index)))
    (0 until s.length).map ( index => map.getOrElse(index, "") ).mkString("")
  }

  class Test(s: String, indices: Array[Int], expected: String) {
    def runTest(): Unit = {
      val result = restoreString(s, indices)
      if (result.equalsIgnoreCase(expected))
        println(">> Passed")
      else println(s">> Failed: got $result instead of $expected")
    }
  }

  val test1 = new Test("codeleet", Array(4,5,6,7,0,2,1,3), "leetcode")
  test1.runTest()
}
