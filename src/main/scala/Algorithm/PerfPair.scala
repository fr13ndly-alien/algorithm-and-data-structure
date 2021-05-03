package Algorithm

// https://leetcode.com/problems/number-of-good-pairs/
object PerfPair extends App {
  def numIdenticalPairs(numbers: Array[Int]): Int = {
    var result = 0
    var i = 0
    while (i < numbers.length -1) {
      var j = i + 1
      while (j < numbers.length) {
        if (numbers(i) == numbers(j))
          result += 1
        j += 1
      }
      i += 1
    }
    result
  }

  class Test(numbers: Array[Int], expected: Int) {
    def runTest(): Unit = {
      val rs = numIdenticalPairs(numbers)
      if (rs == expected)
        println(">> Passed!")
      else println(s">> Failed: got $rs instead of $expected")
    }
  }

  val test1 = new Test(Array(1,2,3,1,1,3), 4)
  test1.runTest()
  val test2 = new Test(Array(1,1,1,1), 6)
  test2.runTest()



}
