
import java.util.Optional;
import java.util.NoSuchElementException;

public class OptionalEmail {

    public static void main(String[] args) {

        // Optional containing an email
        Optional<String> email =
                Optional.of("student@example.com");

        // Empty Optional
        Optional<String> emptyEmail = Optional.empty();

        // Display email using ifPresent()
        email.ifPresent(e -> System.out.println("Email: " + e));

        // Provide default email using orElse()
        String defaultEmail =
                emptyEmail.orElse("default@example.com");

        System.out.println("Default Email: " + defaultEmail);

        // Handle missing email using orElseThrow()
        try {
            String requiredEmail = emptyEmail.orElseThrow(
                () -> new NoSuchElementException("Email is missing")
            );

            System.out.println(requiredEmail);

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
