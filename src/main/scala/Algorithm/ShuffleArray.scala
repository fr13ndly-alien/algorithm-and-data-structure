package Algorithm

object ShuffleArray extends App {
  // https://leetcode.com/problems/shuffle-the-array/
  def shuffle(numbers: Array[Int], n: Int): Array[Int] = {
    val rs = scala.collection.mutable.ArrayBuffer.empty[Int]
    (0 to (n-1)) foreach { i =>
      rs.addOne(numbers(i)).addOne(numbers(i+n))
    }
    rs.toArray
  }

  var numbers = Array(2,5,1,3,4,7)
  var n = 3
  println(s">> ${shuffle(numbers, n).mkString(",")} - output: [2,3,5,4,1,7] ")
}
