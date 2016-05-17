def d(n: Long): Long = {
  divisors(n).dropRight(1).sum
}

def isAmicable(a: Long): Boolean = {
  val b = d(a)
  a != b && d(b) == a
}

(1L to 10000L).filter(isAmicable(_)).sum
