def score(s: String): Long = {
  s.map(_ - '@').sum
}

readWordFile("022.txt").sorted.zipWithIndex.map(t => score(t._1) * (t._2 + 1)).sum
