def numConsecutivePrimes(a: Long, b: Long): Int = {
  longStream(0).map(n => square(n) + a * n + b)
               .takeWhile(isPrime)
               .length
}

val candidates = for {
  a <- -999 to 999 by 2
  b <- primes().takeWhile(_ < 1000)
} yield (a * b, numConsecutivePrimes(a, b))

candidates.maxBy(_._2)._1
