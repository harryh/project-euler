val grid = readNumberGridFile("011.txt")

val maxX = grid(0).length - 1
val maxY = grid.length - 1

def inBounds(x: Long, y: Long): Boolean = {
  (x >= 0) && (x <= maxX) && (y >= 0) && (y <= maxY)
}

val maxOffset = 3

val results = for {
  x <- 0 to maxX
  y <- 0 to maxY
  (deltax, deltay) <- List((1,0), (0, 1), (1, 1), (1, -1)) if inBounds(x + maxOffset * deltax, y + maxOffset * deltay)
} yield {
  val values = for (n <- 0 to maxOffset) yield grid(y + n * deltay)(x + n * deltax)
  values.product
}

results.max
