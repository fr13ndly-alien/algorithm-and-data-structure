package Algorithm
import scala.math.BigInt.int2bigInt
import scala.math.sqrt
object Circle extends App {
  def countPoints(points: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val rs = scala.collection.mutable.ArrayBuffer.empty[Int]
    var nContainedPoint = 0
    queries.foreach { circle =>
      val circleX :: circleY :: circleR :: Nil = circle.toList
      points.foreach { point =>
        val pointX :: pointY :: Nil = point.toList
        if (isPointInsideTheCircle(pointX, pointY, circleX, circleY, circleR))
          nContainedPoint += 1
      }
      rs.addOne(nContainedPoint)
      nContainedPoint = 0
    }
    rs.toArray
  }

  def isPointInsideTheCircle(px: Int, py: Int, cx: Int, cy: Int, cr: Int): Boolean = {
    val dist = sqrt(((px - cx).pow(2) + (py - cy).pow(2)).toDouble)
    dist <= cr.toDouble
  }
}
