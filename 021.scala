def d(n: Long): Long = {
  properDivisors(n).sum
}

def isAmicable(a: Long): Boolean = {
  val b = d(a)
  a != b && d(b) == a
}

(1L to 10000L).filter(isAmicable).sum
