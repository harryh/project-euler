import scala.collection.immutable.SortedSet

val candidates = (1 to 28123)

val abundants = SortedSet(candidates:_*).filter(n => sumOfProperDivisors(n) > n)

def isSumOf2Abundants(n: Int): Boolean = {
  abundants.takeWhile(_ < n)
           .exists(i => abundants.contains(n - i))
}

candidates.filterNot(isSumOf2Abundants).sum
