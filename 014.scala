val cache = scala.collection.mutable.HashMap(1L -> 1L)

def collatzLength(n: Long): Long = {
  def getNext(n: Long): Long = {
    if (isEven(n)) n / 2 else 3 * n + 1
  }

  cache.getOrElseUpdate(n, {
    1 + collatzLength(getNext(n))
  })
}

(1L to 999999L).maxBy(collatzLength)
