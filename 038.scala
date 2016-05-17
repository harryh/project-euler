val candidates = for {
  n <- 2 to 9
  i <- 1L to pow(10, 9 / n)
} yield BigInt((1 to n).map(i * _).mkString)

candidates.filter(isPandigital).max
