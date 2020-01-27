val digits = longs(0).flatMap(_.toString).map(_.asDigit)

LazyList.iterate(1)(_ * 10)
        .map(digits)
        .take(7)
        .product
