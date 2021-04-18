package Algorithm

object RunSum extends  App {
  def runningSum(nums: Array[Int]): Array[Int] = {
    var currSum = 0
    val result = scala.collection.mutable.ListBuffer.empty[Int]
    for (num <- nums) {
      currSum += num
      result.addOne(currSum)
    }
    result.toArray
  }

  var input = Array(1,2,3,4)
  var output = Array(1,3,6,10)
  println(s">> result: ${runningSum(input).mkString(",")} - ${output.mkString(",")}")
}
