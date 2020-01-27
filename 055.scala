def isLychrel(n: BigInt): Boolean = {
  def iterate(n: BigInt): BigInt = {
    n + BigInt(n.toString.reverse)
  }
  !LazyList.iterate(n)(iterate).take(50).tail.exists(isPalindromic)
}

(BigInt(1) to 9999).count(isLychrel)
