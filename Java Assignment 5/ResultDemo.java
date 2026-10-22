
import java.util.*;

class Result<T extends Number> {

    private final List<T> marks;

    Result(List<T> marks) {
        this.marks = Objects.requireNonNull(marks, "Marks required");
    }

    double average() {
        if (marks.isEmpty()) {
            throw new IllegalStateException("No marks available");
        }

        double total = 0.0;

        for (T mark : marks) {
            total += Objects.requireNonNull(mark).doubleValue();
        }

        return total / marks.size();
    }

    double percentage(double maximumMarks) {
        return (average() / maximumMarks) * 100;
    }

    boolean hasPassed(double passPercentage, double maximumMarks) {
        return percentage(maximumMarks) >= passPercentage;
    }
}

public class ResultDemo {

    public static void main(String[] args) {

        Result<Integer> result = new Result<>(
                Arrays.asList(75, 80, 68)
        );

        Optional<Result<Integer>> available =
                Optional.of(result);

        available.ifPresent(r -> {
            System.out.println("Average: " + r.average());
            System.out.println(
                "Percentage: " + r.percentage(100) + "%"
            );
            System.out.println(
                "Passed: " + r.hasPassed(40, 100)
            );
        });
    }
}
