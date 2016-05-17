def isSumOfFifthPowerOfDigits(n: Long): Boolean = {
  digits(n).map(pow(_, 5)).sum == n
}

(2L to 1000000L).filter(isSumOfFifthPowerOfDigits).sum
