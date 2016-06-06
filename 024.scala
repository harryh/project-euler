var digits = (0 to 9).toList
var remain = BigInt(1000000 - 1)

(for (i <- 1 to digits.length) yield {
  val j = remain / factorial(10 - i)
  remain = remain % factorial(10 - i)
  val (a, b) = digits.splitAt(j.toInt)
  digits = a ++ b.tail
  b.head
}).mkString
