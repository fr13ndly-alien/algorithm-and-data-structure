package Algorithm

object Palindrome extends App {
  def isPalindrome(number: Int): Boolean = {
    // false if given number < 0 or number=10
    if (number < 0 || (number%10 == 0 && number != 0))
      false
    else {
      var originNumber = number
      var revertedNumber = 0
      while (originNumber > revertedNumber) {
        revertedNumber = (revertedNumber*10) + (originNumber % 10)
        originNumber = originNumber / 10
      }
      originNumber == revertedNumber || originNumber == revertedNumber/10
    }
  }

  var input = 121
  println(s"> ${isPalindrome(input)} - true")

  input = -121
  println(s"> ${isPalindrome(input)} - false")
  input = 122222221
  println(s"> ${isPalindrome(input)} - true")
  input = 1234554321
  println(s"> ${isPalindrome(input)} - true")

}
