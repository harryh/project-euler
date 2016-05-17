def isTruncatablePrime(n: Long): Boolean = {
  val splits = Stream.iterate(10)(_ * 10).takeWhile(_ <= n).flatMap(i => List(n / i, n % i))
  (n :: splits.toList).forall(isPrime)
}

longStream(8).filter(isTruncatablePrime).take(11).sum
