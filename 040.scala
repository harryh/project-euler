val digits = longStream(0).flatMap(_.toString).map(_ - '0')

Stream.iterate(1)(_ * 10)
      .map(digits)
      .take(7)
      .reduceLeft(_*_)
