val denominations = List(1, 2, 5, 10, 20, 50, 100, 200)
val target = 200

def numWays(target: Int, denominations: List[Int]): Int = {
  if (target == 0) {
    1
  } else {
    denominations.filter(_ <= target).map(d => {
      numWays(target - d, denominations.filter(_ <= d))
    }).sum
  }
}

numWays(target, denominations)
