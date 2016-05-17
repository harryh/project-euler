(for {
  x <- 100L to 999L
  y <- x    to 999L
} yield x * y).filter(isPalindromic).max
