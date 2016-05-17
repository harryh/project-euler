// http://www.mathblog.dk/project-euler-69-find-the-value-of-n-%E2%89%A4-1000000-for-which-n%CF%86n-is-a-maximum/
primes().scanLeft(1L)(_*_).takeWhile(_ < 1000000).last
