def hasPandigitalProduct(n: Int): Boolean = {
  properDivisors(n).map(i => List(n, i, n/i).mkString)
                   .filter(_.length == 9)
                   .exists(isPandigital)
}

(1 until 10000).filter(hasPandigitalProduct).sum
