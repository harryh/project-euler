var digits = (0 to 9).toList
var remain = BigInt(1000000 - 1)

for (i <- 1 to digits.length) {
  val split = remain / factorial(10 - i)
  remain = remain % factorial(10 - i)
  val (a, b::c) = digits.splitAt(split.toInt)
  digits = a ++ c :+ b
}

digits.mkString
