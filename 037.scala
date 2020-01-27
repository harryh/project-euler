def isTruncatablePrime(n: Long): Boolean = {
  LazyList.iterate(10)(_ * 10).takeWhile(_ <= n)
                              .flatMap(i => List(n / i, n % i))
                              .forall(isPrime)
}

primes().filter(_ > 10).filter(isTruncatablePrime).take(11).sum
