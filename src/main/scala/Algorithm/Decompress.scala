package Algorithm

object Decompress extends App {

  // https://leetcode.com/problems/decompress-run-length-encoded-list
  def decompressRLElist(numbers: Array[Int]): Array[Int] = {
    val result = scala.collection.mutable.ArrayBuffer.empty[Int]
    var i = 0
    var j = i + 1

    while (j < numbers.length) {
      val freq = numbers(i)
      val value = numbers(j)
      (0 until freq) foreach( _ =>  result.addOne(value))
      i += 2
      j = i + 1
    }
    result.toArray
  }

  var input = Array(1,2,3,4)
  var rs = decompressRLElist(input)
  println(s">> [${rs.mkString(",")}]")
 }
