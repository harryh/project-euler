def hasPandigitalProduct(n: Int): Boolean = {
  properDivisors(n).map(i => List(n, i, n/i).mkString)
                   .filter(_.length == 9)
                   .exists(isPandigital)
}

(1234 to 9876).filter(hasPandigitalProduct).sum
