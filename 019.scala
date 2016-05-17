import java.time.LocalDate
import java.time.DayOfWeek.SUNDAY

val start = LocalDate.of(1901,  1,  1)
val end   = LocalDate.of(2000, 12, 31)

Stream.iterate(start)(_.plusMonths(1))
      .takeWhile(_.isBefore(end))
      .count(_.getDayOfWeek() == SUNDAY)
