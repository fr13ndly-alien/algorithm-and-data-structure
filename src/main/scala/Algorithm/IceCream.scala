package Algorithm

// https://leetcode.com/problems/maximum-ice-cream-bars/
object IceCream extends App{
  def maxIceCream(costs: Array[Int], coins: Int): Int = {
    // just sort and get first n item can buy with the given coins
    var count = 0
    var coinsLeft = coins
    var index = 0
    val sorted = costs.sortWith(_ < _)
    while (coinsLeft > 0 && index < costs.length) {
      coinsLeft -= sorted(index)
      if (coinsLeft >= 0)
        count += 1
      index += 1
    }
    count
  }

  var input = Array(1,3,2,4,1) // ==> (1,1,2,3,4)
  println(s">> ${maxIceCream(input, 7)} - 4")

  input = Array(10,6,8,7,7,8)
  println(s">> ${maxIceCream(input, 5)} - 0")
}
