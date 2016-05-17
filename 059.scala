val cipherText = inputFile("059.txt").flatMap(_.split(",")).map(_.toInt.toChar).mkString

val keys = for {
  a <- 'a' to 'z'
  b <- 'a' to 'z'
  c <- 'a' to 'z'
} yield List(a, b, c)

def decode(cipherText: String, key: List[Char]): String = {
  val keys = Stream.continually(key).flatten
  cipherText.zip(keys).map(t => (t._1 ^ t._2).toChar).mkString
}

keys.map(key => decode(cipherText, key))
    .maxBy(_.count(_.isLetter))
    .map(_.toInt)
    .sum
