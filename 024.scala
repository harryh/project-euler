(1 to 10).foldLeft(("0123456789", 1000000 - 1))((tuple, i) => {
  val (digits, remain) = tuple
  val fact = factorial(digits.length - i).toInt
  val (a, b) = digits.splitAt(remain / fact)
  (a + b.tail + b.head, remain % fact)
})._1
