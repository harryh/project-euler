def collatzLength(n: Int): Int = {
  @annotation.tailrec
  def collatzLength(n: Long, acc: Int): Int = {
    if (n == 1) {
      acc
    } else {
      val next = if (isEven(n)) n / 2 else 3 * n + 1
      collatzLength(next, acc + 1)
    }
  }
  collatzLength(n, 1)
}

(1 until 1000000).maxBy(collatzLength)
