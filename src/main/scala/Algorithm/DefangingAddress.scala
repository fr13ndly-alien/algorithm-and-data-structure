package Algorithm

object DefangingAddress extends App {
  // https://leetcode.com/problems/defanging-an-ip-address/
  def defangIPaddr(address: String): String = address.replace(".", "[.]")

  var input = "1.1.1.1"
  println(s">> ${defangIPaddr(input)} - output: 1[.]1[.]1[.]1")
}
