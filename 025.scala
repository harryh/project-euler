val threshold = BigInt(10).pow(1000 - 1)

fibonacci().zipWithIndex.find(t => t._1 >= threshold).get._2 + 1
