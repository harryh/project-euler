val pyramid = readNumberGridFile("067.txt")

lazy val maxSum: (Int, Int) => Long = memoize((row, column) => {
  if (row == pyramid.length - 1) {
    pyramid(row)(column)
  } else {
    val a = maxSum(row + 1, column)
    val b = maxSum(row + 1, column + 1)
    pyramid(row)(column) + math.max(a, b)
  }
})

maxSum(0, 0)
