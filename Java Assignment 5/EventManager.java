
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class EventManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String name = sc.nextLine();

        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time (HH:MM): ");
        LocalTime start = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (leave blank if absent): ");
        String venueInput = sc.nextLine().trim();

        Optional<String> venue = venueInput.isEmpty()
                ? Optional.empty()
                : Optional.of(venueInput);

        LocalDate today = LocalDate.now();

        // Display event details
        System.out.println("\nEvent Name: " + name);
        System.out.println("Event Date: " + date);
        System.out.println("Start Time: " + start);
        System.out.println(
            "Venue: " + venue.orElse("Venue not specified")
        );

        // Check event date
        if (date.isAfter(today)) {
            System.out.println("Event is in the future");
        } else if (date.isEqual(today)) {
            System.out.println("Event is today");
        } else {
            System.out.println("Event is in the past");
        }

        // Calculate days remaining
        long days = ChronoUnit.DAYS.between(today, date);
        System.out.println("Days Remaining: " + days);

        // Event lasts two hours
        LocalTime end = start.plusHours(2);
        System.out.println("End Time: " + end);

        sc.close();
    }
}
