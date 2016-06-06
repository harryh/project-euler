var digits = (0 to 9).toList
var remain = 1000000 - 1

for (i <- 1 to digits.length) {
  val fact = factorial(10 - i).toInt
  val split = remain / fact
  remain = remain % fact
  val (a, b::c) = digits.splitAt(split)
  digits = a ++ c :+ b
}

digits.mkString
