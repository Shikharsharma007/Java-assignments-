class InsufficientBalanceException extends Exception {
InsufficientBalanceException(String m) { super(m); }
}
class InvalidAmountException extends Exception {
InvalidAmountException(String m) { super(m); }
}
class AccountNotFoundException extends Exception {
AccountNotFoundException(String m) { super(m); }
}
public class Bank {
static class Account {
String number;
double balance;
Account(String n, double b) {
number = n; balance = b;
}
}
static Account findAccount(String number)
throws AccountNotFoundException {
if (!number.equals("A101"))
throw new AccountNotFoundException("Account not found");
return new Account("A101", 5000);
}
static void deposit(Account a, double amount)
throws InvalidAmountException {
if (amount <= 0)
throw new InvalidAmountException("Deposit must be positive");
a.balance += amount;
}
static void withdraw(Account a, double amount)
throws InvalidAmountException, InsufficientBalanceException {
if (amount <= 0)
throw new InvalidAmountException("Withdrawal must be positive");
if (amount > a.balance)
throw new InsufficientBalanceException("Insufficient balance");
a.balance -= amount;
}
public static void main(String[] args) {
try {
Account a = findAccount("A101");
deposit(a, 1000);
withdraw(a, 2000);
System.out.println("Balance = " + a.balance);
} catch (Exception e) {
System.out.println("Error: " + e.getMessage());
}
}
}