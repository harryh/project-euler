def spiralStream(from: Int = 1, step: Int = 2): Stream[Int] = {
  from #:: (from + 1 * step) #:: (from + 2 * step) #:: (from + 3 * step) #:: spiralStream(from + 4 * step, step + 2)
}

val max = square(1001)

spiralStream().takeWhile(_ <= max).sum
