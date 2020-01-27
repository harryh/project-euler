def triangleNumbers(from: Long = 1, step: Long = 2): LazyList[Long] = from #:: triangleNumbers(from + step, step + 1)

triangleNumbers().find(numDivisors(_) > 500).get
