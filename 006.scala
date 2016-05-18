val numbers = 1L to 100L
val sumOfSquares = numbers.map(square).sum
val squareOfSums = square(numbers.sum)
squareOfSums - sumOfSquares
