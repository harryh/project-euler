val threshold = BigInt(10).pow(1000 - 1)

fibonacci().takeWhile(_ < threshold).length + 1
