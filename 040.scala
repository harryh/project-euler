val digits = longStream(0).flatMap(_.toString).map(_.asDigit)

Stream.iterate(1)(_ * 10)
      .map(digits)
      .take(7)
      .product
