package zejj.lab3;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateExample {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Aktualna data i czas: " + now.format(formatter));

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);

        System.out.println("Aktualny czas w Nowym Jorku: " + newYorkTime.format(formatter));

        LocalDate date = LocalDate.now();
        DateRange result = getPreviousMonthRange(date);

        System.out.println("Początek poprzedniego miesiąca: " + result.from());
        System.out.println("Koniec poprzedniego miesiąca: " + result.to());
        System.out.println("Liczba dni między \"from\" a \"to\": " + result.numberBetween());
    }

    public static DateRange getPreviousMonthRange(LocalDate date) {
        YearMonth previousMonth = YearMonth.from(date).minusMonths(1);
        LocalDateTime start = previousMonth.atDay(1).atStartOfDay();
        LocalDateTime end = previousMonth.atEndOfMonth().atTime(LocalTime.MAX);
        long numberBetween = end.toLocalDate().toEpochDay() - start.toLocalDate().toEpochDay() - 1;

        return new DateRange(start, end, numberBetween);
    }

    record DateRange(LocalDateTime from, LocalDateTime to, long numberBetween) {
    }
}
