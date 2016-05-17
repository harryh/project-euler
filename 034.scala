def isSumOfFactorialOfDigits(n: Long): Boolean = {
  digits(n).map(factorial(_)).sum == n
}

(3L to 10000000L).filter(isSumOfFactorialOfDigits).sum
