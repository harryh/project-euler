(for {
  a <- 1 to 99
  b <- 1 to 99
} yield BigInt(a).pow(b)).map(sumDigits).max
