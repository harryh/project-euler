val triangleStream   = longStream(286).map(n => (0.5 * n * (n + 1)).toLong)
val pentagonalStream = longStream(166).map(n => (0.5 * n * (3 * n - 1)).toLong)
val hexagonalStream  = longStream(144).map(n => (n * (2 * n - 1)).toLong)

val streams = List(triangleStream, pentagonalStream, hexagonalStream)

streams.reduceLeft(mergeStreams)
       .sliding(3)
       .find(_.toSet.size == 1)
       .get.head
