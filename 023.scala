val cache = scala.collection.mutable.HashMap(0 -> false)

def isAbundant(n: Int): Boolean = {
  cache.getOrElseUpdate(n, {
    divisors(n).dropRight(1).sum > n
  })
}

def isNotSumOf2Abundants(n: Int): Boolean = {
  !(1 to n / 2).exists(i => isAbundant(i) && isAbundant(n - i))
}

(1 to 28123).filter(isNotSumOf2Abundants).sum
