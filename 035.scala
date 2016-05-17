def isCircularPrime(n: Long): Boolean = {
  val s = n.toString
  (0 to s.length - 1).map(i => s.substring(i) + s.substring(0, i))
                     .map(_.toLong)
                     .distinct
                     .forall(isPrime)
}

(2L to 999999L).count(isCircularPrime)
