(for {
  n <- 1 to 100
  r <- 1 to n
} yield combinations(n, r)).count(_ > 1000000)
