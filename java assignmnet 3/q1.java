public class ExceptionHierarchyDemo {
public static void main(String[] args) {
try { int x = 10 / 0; }
catch (ArithmeticException e) {
System.out.println("ArithmeticException");
}
try { String s = null; System.out.println(s.length()); }
catch (NullPointerException e) {
System.out.println("NullPointerException");
}
try { int[] a = {1, 2}; System.out.println(a[5]); }
catch (ArrayIndexOutOfBoundsException e) {
System.out.println("ArrayIndexOutOfBoundsException");
}
try { int n = Integer.parseInt("abc"); }
catch (NumberFormatException e) {
System.out.println("NumberFormatException");
}
}
}