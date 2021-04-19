
object TwoSumWithAscInput extends App {
  // O(n)
  def twoSum2(numbers: Array[Int], target: Int): Array[Int] = {
    var result = Array.empty[Int]

    var head = 0
    var tail = numbers.length -1
    while (tail > head) {
      val sum = numbers(head) + numbers(tail)
      if (sum == target) {
        // increase to 1, to make them human reachable, as problem required
        result = Array(head +1, tail +1)
        tail = head -1
      }
      if (sum > target) tail -= 1
      else head += 1
    }

    result
  }


  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    val valToIdxMap: Map[Int, Int] = numbers.indices.foldLeft(Map.empty[Int, Int])((acc, nxt) => {
      if (acc.contains(numbers(nxt))) {
        acc
      } else {
        acc.updated(numbers(nxt), nxt)
      }
    })

    def go(idx: Iterator[Int] = numbers.indices.iterator): Array[Int] = {
      val nxtIdx = idx.next()
      val complement = target - numbers(nxtIdx)
      if (valToIdxMap.contains(complement) && valToIdxMap(complement) != nxtIdx) {
        if (nxtIdx < valToIdxMap(complement)) Array(nxtIdx, valToIdxMap(complement))
        else Array(valToIdxMap(complement), nxtIdx)
      } else go(idx)
    }
    go().map(_ + 1) // one index
  }

  class TestCase(_nums: Array[Int], _target: Int, _expected: Array[Int]) {
    var nums: Array[Int] = _nums
    var target: Int = _target
    var expected: Array[Int] = _expected

    def runTest(): Unit = {
      val result = twoSum(nums, target)
      if (result sameElements expected)
        println("> Passed")
      else println(s"> result [${result.mkString(",")}] " +
        s"is not equal to [${expected.mkString(",")}]")
    }
  }

  var test1 = new TestCase(Array(2,7,11,15), 9, Array(1,2))
  test1.runTest()

  val test2 = new TestCase(Array(2,3,4), 6, Array(1,3))
  test2.runTest()

  val test3 = new TestCase(Array(2,3,4,10,11,12,13,15,16), 6, Array(1,3))
  test3.runTest()

  val test4 = new TestCase(Array(-5,-4,-3,-2,0,2,3,4,17,20,30,40,50,60), 6, Array(6,8))
  test4.runTest()
}
