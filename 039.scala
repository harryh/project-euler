def isRightTriangle(sides: (Int, Int, Int)): Boolean = {
  square(sides._1) + square(sides._2) == square(sides._3)
} 

def numRightTriangles(perimiter: Int): Long = {
  val candidates = (for {
    a <- 1 to perimiter / 3
    b <- a to ((perimiter - a) / 2)
  } yield (a, b, perimiter - a - b))

  candidates.count(isRightTriangle)
}

(1 to 1000).maxBy(numRightTriangles)
