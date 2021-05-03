package Algorithm

object MatchingRule extends App {
  // https://leetcode.com/problems/count-items-matching-a-rule/
  def countMatches(items: List[List[String]], ruleKey: String, ruleValue: String): Int = {
    val indexByRule = ruleKey match {
      case "type" => 0
      case "color" => 1
      case "name" => 2
      case _ => 0 // default is type
    }
    var result = 0

    items foreach ( item =>
      if (item(indexByRule).equalsIgnoreCase(ruleValue)) result += 1
    )

    result
  }
}
