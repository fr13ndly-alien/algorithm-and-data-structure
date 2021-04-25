package Algorithm

object Richest extends App {
  // url: https://leetcode.com/problems/richest-customer-wealth/
  def maximumWealth(accounts: Array[Array[Int]]): Int = {
    var maximumWealth = 0
    accounts foreach { personalAccount =>
      val sum = personalAccount.sum
      if (sum > maximumWealth) maximumWealth = sum
    }

    maximumWealth
  }

  val input = Array(Array(1,2,3), Array(3,2,1))
  println(s">> ${maximumWealth(input)} - result 6")
}
