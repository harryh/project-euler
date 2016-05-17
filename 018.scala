val pyramid = readNumberGridFile("018.txt")

val cache  = scala.collection.mutable.HashMap.empty[(Int, Int), Long]

val lastRow = pyramid.length - 1
pyramid(lastRow).zipWithIndex.foreach(x => cache.put((lastRow, x._2), x._1))

def maxSum(row: Int, column: Int): Long = {
  val key = (row, column)
  cache.getOrElseUpdate(key, {
    val a = maxSum(row + 1, column)
    val b = maxSum(row + 1, column + 1)
    pyramid(row)(column) + math.max(a, b)
  })
}

maxSum(0, 0)
