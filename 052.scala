def sameDigits(m: Long, n: Long): Boolean = {
  m.toString.toSeq.sorted == n.toString.toSeq.sorted
}

longs().find(m => (2 to 6).forall(n => sameDigits(m, m * n))).get
