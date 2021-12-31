val pentagonals = longs().map(n => (0.5 * n * (3 * n - 1)).toLong)

def isPentagonal(n: Long): Boolean = {
  val x = (sqrt(24 * n + 1) + 1.0) / 6.0
  x.toInt == x
}

(for {
  a <- pentagonals
  b <- pentagonals.takeWhile(_ < a) if isPentagonal(a + b) && isPentagonal(a - b)
} yield (a - b)).head
