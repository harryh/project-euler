val threes = 3 to 1000 by 3
val fives  = 5 to 1000 by 5
(threes union fives).distinct.sum
