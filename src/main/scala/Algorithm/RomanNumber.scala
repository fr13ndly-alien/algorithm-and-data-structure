package Algorithm

object RomanNumber extends App {
  def romanToInt(romanNumber: String): Int = {
    var index = 0
    var number = 0
    while (index < romanNumber.length) {
      romanNumber.charAt(index) match {
        case 'M' => number += 1000
        case 'D' => number += 500
        case 'L' => number += 50
        case 'V' => number += 5
        case 'I' =>
          if (index + 1 < romanNumber.length) {
            romanNumber.charAt(index + 1) match {
              case 'V' =>
                number += 4
                index += 1
              case 'X' =>
                number += 9
                index += 1
              case _ => number += 1
            }
          } else number += 1
        case 'X' =>
          if (index + 1 < romanNumber.length) {
            romanNumber.charAt(index + 1) match {
              case 'L' =>
                number += 40
                index += 1
              case 'C' =>
                number += 90
                index += 1
              case _ => number += 10
            }
          } else number += 10
        case 'C' =>
          if (index + 1 < romanNumber.length) {
            romanNumber.charAt(index + 1) match {
              case 'D' =>
                number += 400
                index += 1
              case 'M' =>
                number += 900
                index += 1
              case _ => number += 100
            }
          } else number += 100

      }
      index += 1
    }
    number
  }


  var input = "III"
  println(s">> Roman to int: ${romanToInt(input)} - 3")

  input = "IV"
  println(s">> Roman to int: ${romanToInt(input)} - 4")
}
