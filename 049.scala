val plist = primes().filter(_ > 999)
                    .filter(_ != 1487)
                    .takeWhile(_ < 10000)
(for {
  a <- plist
  b <- plist if b > a
  c <- List(2 * b - a) if (c < 10000) && isPrime(c) && isPermutation(a, b, c)
} yield "" + a + b + c).head
