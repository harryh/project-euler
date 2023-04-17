def cycleLength(n: Long): Long = {
  var m = 10 % n
  var t = 1
  while (m != 1) {
    m = m * 10 % n
    t = t + 1
  }
  t
}

primes().filter(_ > 5)
        .takeWhile(_ < 1000)
        .maxBy(cycleLength)
