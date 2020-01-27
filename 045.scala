val triangles   = longs(286).map(n => (0.5 * n * (n + 1)).toLong)
val pentagonals = longs(166).map(n => (0.5 * n * (3 * n - 1)).toLong)
val hexagonals  = longs(144).map(n => (n * (2 * n - 1)).toLong)

val numbers = List(triangles, pentagonals, hexagonals)

numbers.reduceLeft(merge)
       .sliding(3)
       .find(_.toSet.size == 1)
       .get.head
