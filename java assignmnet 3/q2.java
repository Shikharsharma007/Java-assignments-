public class NestedTryCatch {
public static void main(String[] args) {
try {
try {
int[] a = {1, 2};
System.out.println(a[5]);
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Handled in inner catch");
}
int x = 10 / 0;
} catch (ArithmeticException e) {
System.out.println("Handled in outer catch");
}
}
}
