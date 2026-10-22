
public class GenericSum {

    public static <T extends Number> double sum(T[] values) {
        double total = 0.0;

        for (T value : values) {
            total += value.doubleValue();
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4};
        Float[] floats = {1.5f, 2.5f, 3.0f};
        Double[] doubles = {2.2, 3.3, 4.4};

        System.out.println("Integer Sum: " + sum(integers));
        System.out.println("Float Sum: " + sum(floats));
        System.out.println("Double Sum: " + sum(doubles));
    }
}
