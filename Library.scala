import java.time.{Duration, Instant}

def timeAndPrintSolution[A](number: String, f: () => A): Unit = {
  val start = Instant.now()
  val result = f()
  val d = Duration.between(start, Instant.now())
  val correct = answers.get(number).exists(_ == result.toString)
  val check = if (correct) "✓" else "✗"
  System.out.println(number + " (" + d.toMillis + "ms):\t" + result.toString + " " + check)
}

val answers = {
  inputFile("answers.txt").map(_.split(" "))
                          .map(a => (a(0), a(1)))
                          .toMap
}

def memoize[A1, B](f: A1 => B): A1 => B = {
  val cache = new scala.collection.mutable.HashMap[A1, B]()
  (a) => {
    cache.getOrElseUpdate(a, f(a))
  }
}

def memoize[A1, A2, B](f: (A1, A2) => B): (A1, A2) => B = {
  val cache = new scala.collection.mutable.HashMap[(A1, A2), B]()
  (a1, a2) => {
    cache.getOrElseUpdate((a1, a2), f(a1, a2))
  }
}

def negate[A](f: A => Boolean): A => Boolean = {
  (a: A) => !f(a)
}

def isMultipleOf(n: Long, i: Long): Boolean = n % i == 0
def isMultipleOf(n: BigInt, i: BigInt): Boolean = n % i == 0

def isEven(n: Long) = isMultipleOf(n, 2)
def isEven(n: BigInt) = isMultipleOf(n, 2)

def isOdd(n: Long) = !isEven(n)
def isOdd(n: BigInt) = !isEven(n)

@annotation.tailrec
def pow(x: Long, y: Long, acc: Long = 1): Long = {
  if (y == 0) acc else pow(x, y - 1, x * acc)
}

def sqrt(n: Long): Double = math.sqrt(n.toDouble)

def square(n: Long): Long = pow(n, 2)
def isSquare(n: Long): Boolean = {
  val s = sqrt(n).toLong
  square(s) == n
}

def inputFile(filename: String): Iterator[String] = {
  scala.io.Source.fromFile(filename).getLines()
}

def readNumberGridFile(filename: String): Vector[Vector[Long]] = {
  inputFile(filename).map(_.split(" ").map(_.toLong).toVector).toVector
}

def readBigIntFile(filename: String): Vector[BigInt] = {
  inputFile(filename).map(BigInt(_)).toVector
}

def readWordFile(filename: String): Vector[String] = {
  inputFile(filename).flatMap(_.split(",")).map(_.init.tail).toVector
}

// def iteratedStream[A](from: A)(f: A => Option[A]): LazyList[A] = {
//   f(from).map(from #:: iteratedStream(_)(f))
//          .getOrElse(LazyList(from))
// }

def merge(as: LazyList[Long], bs: LazyList[Long]): LazyList[Long] = {
  (as, bs) match {
    case (LazyList(), bss) => bss
    case (ass, LazyList()) => ass
    case (a #:: ass, b #:: bss) if (a < b) => a #:: merge(ass, bs)
    case (_, b #:: bss) => b #:: merge(as, bss)
  }
}

def longs(from: Long = 1L, step: Long = 1L): LazyList[Long] = from #:: longs(from + step, step)

def fibonacci(a: BigInt = 1, b: BigInt = 1): LazyList[BigInt] = a #:: fibonacci(b, a + b)

def properDivisors(n: Long): List[Long] = {
  (1L to n / 2).filter(i => isMultipleOf(n, i)).toList
}

def sumOfProperDivisors(n: Long): Long = {
  properDivisors(n).sum
}

def numDivisors(n: Long): Long = {
  val end = sqrt(n).toLong
  (if (isSquare(n)) -1 else 0) +
    (1L to end).count(i => isMultipleOf(n, i)) * 2
}

object Prime {
  def is(i: Long) = {
    if (i < 2) false
    else if (i == 2) true
    else if ((i & 1) == 0) false // efficient div by 2
    else prime(i)
  }

  def primes: LazyList[Long] = 2 #:: prime3

  private val prime3: LazyList[Long] = {
    @annotation.tailrec
    def nextPrime(i: Long): Long = if (prime(i)) i else nextPrime(i + 2)
    def next(i: Long): LazyList[Long] = i #:: next(nextPrime(i + 2))
    3 #:: next(5)
  }

  // assumes not even, check evenness before calling - perf note: must pass partially applied >= method
  private def prime(i: Long) = prime3.takeWhile(sqrt(i) >= _).forall(i % _ != 0)
}

def isPrime(n: Long) = Prime.is(n)
def isComposite(n: Long) = !isPrime(n)

def primes() = Prime.primes

@annotation.tailrec
def primeFactors(number: Long, list: List[Long] = List()): List[Long] = {
  if (number == 1) {
    list
  } else {
    val factor = primes().find(number % _ == 0).get
    primeFactors(number / factor, list :+ factor)
  }
}

def gcd(x: Long, y: Long): Long = {
  val commonFactors = primeFactors(x) intersect primeFactors(y)
  commonFactors.foldLeft(1L)(_*_)
}

def lcm(x: Long, y:Long): Long = {
  (x * y) / gcd(x, y)
}

def isRelativelyPrime(m: Long, n: Long): Boolean = {
  gcd(m, n) == 1
}

def φ(nn: Long): Long = {
  var n = nn
  var p = 1L
  var i = 2L
  var end = sqrt(n)
  while (i <= end) {
    if (n % i == 0) {  // Found a factor
      p = p * (i - 1)
      n  = n / i
      while (n % i == 0) {
        p = p * i
        n = n / i
      }
      end = sqrt(n)
    }
    i = i + 1
  }
  if (n != 1) {
    p = p * (n - 1)
  }
  p
}

@annotation.tailrec
def factorial(n: Long, acc: BigInt = 1): BigInt = {
  if (n == 0) acc else factorial(n - 1, acc * n)
}

def permutations(n: Long, k: Long): Long = {
  (factorial(n) / factorial(n - k)).toLong
}

def combinations(n: Long, k: Long): BigInt = {
  factorial(n) / (factorial(k) * factorial(n - k))
}

@annotation.tailrec
def digits(n: Long, acc: List[Int] = Nil): List[Int] = {
  if (n == 0) acc else digits(n / 10, (n % 10).toInt :: acc)
}

@annotation.tailrec
def digits(n: BigInt, acc: List[Int]): List[Int] = {
  if (n == 0) {
    acc
  } else {
    val (d, m) = n /% 10
    digits(d, m.toInt :: acc)
  }
}

def digits(n: BigInt): List[Int] = digits(n, Nil)
def countDigits(n: BigInt): Long = digits(n).length
def sumDigits(n: BigInt): Long = digits(n).sum

def countDigits(n: Long): Long = digits(n).length

def digits(s: String): List[Int] = {
  s.toList.map(_.asDigit)
}

def isPalindromic(n: Long, base: Int): Boolean = {
  val s = java.lang.Long.toString(n, base)
  s.reverse.equals(s)
}

def isPalindromic(n: Long): Boolean = isPalindromic(n, 10)

def isPalindromic(n: BigInt): Boolean = {
  val s = n.toString
  s.reverse.equals(s)
}

def isPandigital(n: BigInt): Boolean = {
  val d = digits(n)
  (1 to d.length) == d.sorted
}

def isPandigital(n: Long): Boolean = {
  val d = digits(n)
  (1 to d.length) == d.sorted
}

def isPandigital(n: String): Boolean = {
  val d = digits(n)
  (1 to d.length) == d.sorted
}

def isPermutation(numbers: Long*): Boolean = {
  !numbers.isEmpty && {
    val strings = numbers.map(_.toString.toSeq.sorted)
    strings.tail.forall(_ == strings.head)
  }
}
