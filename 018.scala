val pyramid = readNumberGridFile("018.txt")

val cache  = scala.collection.mutable.HashMap.empty[(Int, Int), Long]

pyramid.last.zipWithIndex.foreach(x => cache.put((pyramid.length - 1, x._2), x._1))

def maxSum(row: Int, column: Int): Long = {
  cache.getOrElseUpdate((row, column), {
    val a = maxSum(row + 1, column)
    val b = maxSum(row + 1, column + 1)
    pyramid(row)(column) + math.max(a, b)
  })
}

maxSum(0, 0)
