package Algorithm

object CompressString extends App {

  //https://leetcode.com/problems/create-target-array-in-the-given-order/
  def createTargetArray(numbers: Array[Int], index: Array[Int]): Array[Int] = {
    val result = scala.collection.mutable.ArrayBuffer.empty[Int]
    (0 until numbers.length).foreach { i =>
      result.insert(index(i), numbers(i))
    }
    result.toArray
  }

  class Test(numbers: Array[Int], index: Array[Int], target: Array[Int]) {
    def runTest(): Unit = {
      val rs = createTargetArray(numbers, index)
      if (rs.equals(target))
        println(">> Passed!")
      else println(s">> Failed! got [${rs.mkString(",")}] instead of [${target.mkString(",")}]")
    }
  }

  val test1 = new Test(Array(0,1,2,3,4), Array(0,1,2,2,1), Array(0,4,1,3,2))
  test1.runTest()
}
