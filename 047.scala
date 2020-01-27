longs().filter(n => primeFactors(n).distinct.length == 4)
       .sliding(4)
       .find(s => s(3) - s(0) == 3)
       .get.head
