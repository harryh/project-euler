val digits = "0123456789"

def pickDigit(tuple: (String, Int), i: Int): (String, Int) = {
  val (digits, remain) = tuple
  val fact = factorial(digits.length - i).toInt
  val (a, b) = digits.splitAt(remain / fact)
  (a + b.tail + b.head, remain % fact)
}

(1 to digits.length).foldLeft((digits, 1000000 - 1))(pickDigit)._1
