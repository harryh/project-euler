def spiral(from: Int = 1, step: Int = 2): LazyList[Int] = {
  from #:: (from + 1 * step) #:: (from + 2 * step) #:: (from + 3 * step) #:: spiral(from + 4 * step, step + 2)
}

val max = square(1001)

spiral().takeWhile(_ <= max).sum
