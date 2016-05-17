val max = pow(10, 6)
val maxLength = primes().scanLeft(0L)(_+_).indexWhere(_ >= max) - 1

val findRangeWithLength = Function.unlift((n: Int) => {
  primes().sliding(n).map(_.sum).takeWhile(_ < max).find(isPrime)
})

(maxLength to 1 by -1).collectFirst(findRangeWithLength).get
