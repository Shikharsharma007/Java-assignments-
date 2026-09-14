import java.util.*;
public class Calculator {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
try {
System.out.print("First number: ");
double a = Double.parseDouble(sc.nextLine());
System.out.print("Operator: ");
String op = sc.nextLine();
System.out.print("Second number: ");
double b = Double.parseDouble(sc.nextLine());
double result;
switch (op) {
case "+": result = a + b; break;
case "-": result = a - b; break;
case "*": result = a * b; break;
case "/":
if (b == 0)
throw new ArithmeticException("Division by zero");
result = a / b;
break;
default:
throw new IllegalArgumentException("Invalid operator");
}
System.out.println("Result = " + result);
} catch (NumberFormatException e) {
System.out.println("Invalid numeric input");
} catch (ArithmeticException e) {
System.out.println(e.getMessage());
} catch (IllegalArgumentException e) {
System.out.println(e.getMessage());
}
}
}