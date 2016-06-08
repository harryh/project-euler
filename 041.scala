primes().takeWhile(_ <= 7654321)
        .reverse
        .filter(isPandigital)
        .head
