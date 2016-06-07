val pentagonalStream = longStream().map(n => (0.5 * n * (3 * n - 1)).toLong)

def isPentagonal(n: Long): Boolean = {
  val x = (math.sqrt(24 * n + 1) + 1.0) / 6.0
  x.toInt == x
}

(for {
  a <- pentagonalStream
  b <- pentagonalStream.takeWhile(_ < a) if isPentagonal(a + b) && isPentagonal(a - b)
} yield (a - b)).head
