import java.util.*;
class InvalidMarksException extends Exception {
InvalidMarksException(String message) {
super(message);
}
}
public class StudentResult {
static void validate(int marks) throws InvalidMarksException {
if (marks < 0 || marks > 100)
throw new InvalidMarksException(
"Marks must be between 0 and 100");
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
try {
int total = 0;
for (int i = 1; i <= 5; i++) {
System.out.print("Marks for subject " + i + ": ");
int marks = sc.nextInt();
validate(marks);
total += marks;
}
double percentage = total / 5.0;
char grade = percentage >= 90 ? 'A' :
percentage >= 75 ? 'B' :
percentage >= 60 ? 'C' :
percentage >= 40 ? 'D' : 'F';
System.out.println("Total = " + total);
System.out.println("Percentage = " + percentage);
System.out.println("Grade = " + grade);
} catch (InvalidMarksException e) {
System.out.println("Error: " + e.getMessage());
}
}
}