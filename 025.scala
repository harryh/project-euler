val threshold = BigInt(10).pow(1000 - 1)

fibonacci(0).takeWhile(_ < threshold).length
