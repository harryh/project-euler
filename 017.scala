val ONES = List("zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen")

val TENS = List("", "", "twenty", "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety")

def intToEnglish(n: Int): String = {
  if (0 <= n && n < 20) {
    ONES(n);
  } else if (20 <= n && n < 100) {
    TENS(n / 10) + (if (n % 10 != 0) "-" + ONES(n % 10) else "")
  } else if (100 <= n && n < 1000) {
    ONES(n / 100) + " hundred" + (if (n % 100 != 0) " and " + intToEnglish(n % 100) else "")
  } else if (1000 <= n && n < 1000000) {
    intToEnglish(n / 1000) + " thousand" + (if (n % 1000 != 0) " " + intToEnglish(n % 1000) else "")
  } else {
    ???
  }
}

def removeSpacesAndHyphens(s: String): String = s.replaceAll("[ -]","")

(1 to 1000).map(intToEnglish)
           .map(removeSpacesAndHyphens)
           .map(_.length)
           .sum
