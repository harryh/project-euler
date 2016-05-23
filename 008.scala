inputFile("008.txt").flatMap(_.map(_.asDigit.toLong))
                    .sliding(13)
                    .map(_.product)
                    .max
