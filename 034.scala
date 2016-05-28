val factorials = (1 to 9).scanLeft(1)(_*_)

def isSumOfFactorialOfDigits(n: Int): Boolean = {
  digits(n).map(factorials).sum == n
}

(3 to 10000000).filter(isSumOfFactorialOfDigits).sum
