package Algorithm

object NumberOfSteps extends App {
  // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
  def numberOfSteps(number: Int): Int = {
    var steps = 0
    var numberAfterReduce = number
    while (numberAfterReduce > 0) {
      if (numberAfterReduce % 2 == 0)
        numberAfterReduce = numberAfterReduce / 2
      else numberAfterReduce -= 1
      steps += 1
    }
    steps
  }

  class Test (number: Int, expected: Int) {
    def runTest(): Unit = {
      val result = numberOfSteps(number)
      if (result == expected)
        println(">> Passed!")
      else println(s">> Failed: got $result instead of $expected")
    }
  }

  val test1 = new Test(8,4)
  test1.runTest()

  val test2 = new Test(14, 6)
  test2.runTest()

  val test3 = new Test(123, 12)
  test3.runTest()
}
