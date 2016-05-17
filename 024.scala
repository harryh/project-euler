def nextLexographicPermutation(from: String): Option[String] = {
  Some(from)
}

iteratedStream("0123456789".sorted)(nextLexographicPermutation)(1000000 - 1)
