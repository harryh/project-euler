val digits = scala.io.Source.fromFile("008.txt")
                            .getLines()
                            .flatMap(_.toList.map(d => (d - '0').toLong))
                            .toVector
val n = 13
val options = for (i <- 0 to digits.length - n) yield digits.slice(i, i + n).reduceLeft(_*_)
options.max
