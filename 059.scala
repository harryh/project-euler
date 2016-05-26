val cipherText = inputFile("059.txt").flatMap(_.split(",")).map(_.toInt.toChar).mkString

def decode(key: Char*): String = {
  val keys = Stream.continually(key).flatten
  cipherText.zip(keys).map(t => (t._1 ^ t._2).toChar).mkString
}

val letters = 'a' to 'z'
val plainTexts = for (a <- letters; b <- letters; c <- letters) yield decode(a, b, c)

plainTexts.maxBy(_.count(_.isLetter))
          .map(_.toInt)
          .sum
