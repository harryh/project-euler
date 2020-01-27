val triangles = longs().map(n => (0.5 * n * (n + 1)).toLong)

def isTriangleNumber(n: Int): Boolean = {
  triangles.takeWhile(_ <= n).last == n
}

def isTriangleWord(s: String): Boolean = {
  val wordValue = s.toList.map(_ - '@').sum
  isTriangleNumber(wordValue)
}

readWordFile("042.txt").count(isTriangleWord)
