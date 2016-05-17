def isTriplet(a: Long, b: Long, c: Long): Boolean = {
  a < b && b < c && square(a) + square(b) == square(c)
}

val results = for {
  a <- 1 to 1000
  b <- a + 1 to 1000 if isTriplet(a, b, 1000 - a - b)
} yield a * b * (1000 - a - b)

results.head
