def sameDigits(m: Long, n: Long): Boolean = {
  m.toString.sorted == n.toString.sorted
}

longs().find(m => (2 to 6).forall(n => sameDigits(m, m * n))).get
