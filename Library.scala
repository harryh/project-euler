import java.time.{Duration, Instant}

def timeAndPrintSolution[A](number: String, f: () => A): Unit = {
  val start = Instant.now()
  val result = f()
  val correct = answers.get(number).exists(_ == result.toString)
  val d = Duration.between(start, Instant.now())
  val check = if (correct) "✓" else "✗"
  System.out.println(number + " (" + d.toMillis + "ms):\t" + result.toString + " " + check)
}

val answers = {
  inputFile("answers.txt").map(_.split(" "))
                          .map(a => (a(0), a(1)))
                          .toMap
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

def square(n: Long): Long = pow(n, 2)
def isSquare(n: Long): Boolean = {
  val sqrt = math.sqrt(n).toLong
  square(sqrt) == n
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
  inputFile(filename).flatMap(_.split(",")).map(_.replaceAll("\"","")).toVector
}

def iteratedStream[A](from: A)(f: A => Option[A]): Stream[A] = {
  f(from).map(from #:: iteratedStream(_)(f))
         .getOrElse(Stream(from))
}

def mergeStreams(as: Stream[Long], bs: Stream[Long]): Stream[Long] = {
  (as, bs) match {
    case (Stream.Empty, bss) => bss
    case (ass, Stream.Empty) => ass
    case (a #:: ass, b #:: bss) if (a < b) => a #:: mergeStreams(ass, bs)
    case (_, b #:: bss) => b #:: mergeStreams(as, bss)
  }
}

def longStream(from: Long = 1L, step: Long = 1L): Stream[Long] = from #:: longStream(from + step)

def fibonacci(a: BigInt = 1, b: BigInt = 1): Stream[BigInt] = a #:: fibonacci(b, a + b)

def properDivisors(n: Long): List[Long] = {
  (1L to n / 2).filter(i => isMultipleOf(n, i)).toList
}

def numDivisors(n: Long): Long = {
  val end = math.sqrt(n).toLong
  (if (square(end) == n) 1 else 0) +
    (1L to end - 1).count(i => isMultipleOf(n, i)) * 2
}

object Prime {
  def is(i: Long) = {
    if (i == 1) false
    else if (i == 2) true
    else if ((i & 1) == 0) false // efficient div by 2
    else prime(i)
  }

  def primes: Stream[Long] = 2 #:: prime3

  private val prime3: Stream[Long] = {
    @annotation.tailrec
    def nextPrime(i: Long): Long = if (prime(i)) i else nextPrime(i + 2)
    def next(i: Long): Stream[Long] = i #:: next(nextPrime(i + 2))
    3 #:: next(5)
  }

  // assumes not even, check evenness before calling - perf note: must pass partially applied >= method
  private def prime(i: Long) = prime3.takeWhile(math.sqrt(i) >= _).forall(i % _ != 0)
}

def isPrime(n: Long) = Prime.is(n)
def isComposite(n: Long) = !isPrime(n)

def primes() = Prime.primes

def primeFactors(number: Long, list: List[Long] = List()): List[Long] = {
  for (n <- primes().takeWhile(_ <= number) if (number % n == 0)) {
    return primeFactors(number / n, list :+ n)
  }
  list
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
  var end = math.sqrt(n)
  while (i <= end) {
    if (n % i == 0) {  // Found a factor
      p = p * (i - 1)
      n  = n / i
      while (n % i == 0) {
        p = p * i
        n = n / i
      }
      end = math.sqrt(n)
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
  s.toList.map(_ - '0')
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

def isPermutation(m: Long, n: Long): Boolean = {
  digits(m).sorted.equals(digits(n).sorted)
}
