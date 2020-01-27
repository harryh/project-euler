def isNotSumOfPrimeAndTwiceSquare(n: Long): Boolean = {
  longs().map(i => n - 2 * i * i)
         .takeWhile(_ > 0)
         .forall(isComposite)
}

longs(2).filter(isOdd)
        .filter(isComposite)
        .filter(isNotSumOfPrimeAndTwiceSquare)
        .head
