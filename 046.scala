def isNotSumOfPrimeAndTwiceSquare(n: Long): Boolean = {
  longStream().map(i => n - 2 * i * i)
              .takeWhile(_ > 0)
              .forall(isComposite)
}

longStream(2).filter(isOdd)
             .filter(isComposite)
             .filter(isNotSumOfPrimeAndTwiceSquare)
             .head
