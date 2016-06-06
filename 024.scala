var digits = "0123456789"
var remain = 1000000 - 1

for (i <- 1 to digits.length) {
  val fact = factorial(10 - i).toInt
  val split = remain / fact
  remain = remain % fact
  val (a, b) = digits.splitAt(split)
  digits = a ++ b.tail :+ b.head
}

digits
