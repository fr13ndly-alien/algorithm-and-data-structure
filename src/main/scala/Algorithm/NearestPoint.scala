package Algorithm

// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
object NearestPoint extends App {
  def nearestValidPoint(x: Int, y: Int, points: Array[Array[Int]]): Int = {
    var index = -1
    var minDistance = Int.MaxValue
    points.zipWithIndex.foreach { pointWithIndex =>
      val (point, pointIndex) = pointWithIndex
      val x2 :: y2 :: Nil = point.toList
      val dist = distance(x, y, x2, y2)
      if ((x == x2 || y == y2) && dist < minDistance) {
        minDistance = dist
        index = pointIndex
      }
    }
    index
  }

  def distance(x1: Int, y1: Int, x2: Int, y2: Int): Int =  (x2 - x1).abs + (y2 - y1).abs

  class Test(listPoint: Array[Array[Int]], x: Int, y: Int, expected: Int) {
    def runTest(): Unit = {
      val rs = nearestValidPoint(x, y, listPoint)
      if (rs == expected)
        println(s">> result: $rs - Passed!" )
      else println(s">> Failed! result is $rs while expected: $expected")
    }
  }

  var points = Array(
    Array(1,2),
    Array(3,1),
    Array(2,4),
    Array(2,3),
    Array(4,4)
  )
  val test1 = new Test(points, 3,4,2)
  test1.runTest()
}
