package Algorithm

object Divide extends App {

  // https://leetcode.com/problems/divide-two-integers/
  def divide(dividend: Int, divisor: Int): Int = {
    val hasSign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)
    (dividend, divisor) match {
      case (Int.MinValue, -1) =>
        Int.MaxValue
      case (Int.MinValue, 1) =>
        Int.MinValue
      case (Int.MinValue, Int.MinValue) => 1
      case (0, _) => 0
      case (_, _) =>
        var result = 0
        var dividendLeft = if(dividend == Int.MinValue) Int.MaxValue else if (dividend < 0) 0-dividend else dividend
        val actualDivisor  = if (divisor < 0) 0 - divisor else divisor
        while (dividendLeft >= actualDivisor) {
          result += 1
          dividendLeft -= actualDivisor
        }

        if (hasSign) 0 - result else result
    }
  }




  class Test(dividend: Int, divisor: Int, result: Int) {
    def runTest(): Unit = {
      val rs = divide(dividend, divisor)
      if (rs == result)
        println("\n>> Passed!")
      else
        println(s"\n>> Failed: got $rs instead of $result")
    }
  }


  val test1 = new Test(10, 3, 3)
  test1.runTest()

  val test2 = new Test(7, -3, -2)
  test2.runTest()

  val test3 = new Test(-1, 1, -1)
  test3.runTest()

  val test4 = new Test(1, -1, -1)
  test4.runTest()

  val test5 = new Test(Int.MinValue, -1, Int.MaxValue)
  test5.runTest()

  val test6 = new Test(Int.MinValue, 1, Int.MinValue)
  test6.runTest()

  val test7 = new Test(Int.MinValue, Int.MinValue, 1)
  test7.runTest()

  val test8 = new Test(Int.MinValue, Int.MaxValue, -1)
  test8.runTest()
}
