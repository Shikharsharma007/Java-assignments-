
import java.util.*;

class Utility {

    // Check whether two objects are equal
    static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    // Return value or default
    static <T> T getDefault(Optional<T> value, T defaultValue) {
        return Objects.requireNonNull(value).orElse(defaultValue);
    }

    // Return the larger object
    static <T extends Comparable<? super T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Check whether object is null
    static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class UtilityDemo {

    public static void main(String[] args) {

        System.out.println(
            Utility.isEqual("Java", "Java")
        );

        System.out.println(
            Utility.getDefault(Optional.empty(), "Default")
        );

        System.out.println(
            Utility.max(10, 20)
        );

        System.out.println(
            Utility.max("Apple", "Banana")
        );

        System.out.println(
            Utility.isNull(null)
        );
    }
}
