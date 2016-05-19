val threes = 3 to 999 by 3
val fives  = 5 to 999 by 5
(threes union fives).distinct.sum
