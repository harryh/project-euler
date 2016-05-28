def isCircularPrime(n: Int): Boolean = {
  val s = n.toString
  Stream.iterate(s)(s => s.tail :+ s.head)
        .map(_.toLong)
        .take(s.length)
        .forall(isPrime)
}

(2 until 1000000).count(isCircularPrime)
