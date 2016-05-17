val numbers = 1L to 100L
val sumOfSquares = numbers.map(x => x * x).sum
val squareOfSums = square(numbers.sum)
squareOfSums - sumOfSquares
