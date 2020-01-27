def isCircularPrime(n: Long): Boolean = {
  LazyList.iterate(n.toString)(s => s.tail :+ s.head)
          .tail
          .map(_.toLong)
          .takeWhile(_ != n)
          .forall(isPrime)
}

primes().takeWhile(_ < 1000000).count(isCircularPrime)
