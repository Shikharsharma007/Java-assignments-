class InvalidUsernameException extends Exception {
InvalidUsernameException(String m) { super(m); }
}
class InvalidPasswordException extends Exception {
InvalidPasswordException(String m) { super(m); }
}
class AccountLockedException extends Exception {
AccountLockedException(String m) { super(m); }
}
public class LoginSystem {
static int attempts = 0;
static boolean locked = false;
static void login(String user, String pass) throws Exception {
if (locked)
throw new AccountLockedException("Account is locked");
if (!user.equals("admin"))
throw new InvalidUsernameException("Invalid username");
if (!pass.equals("java123")) {
attempts++;
if (attempts >= 3) locked = true;
throw new InvalidPasswordException("Invalid password");
}
System.out.println("Login successful");
}
public static void main(String[] args) {
try {
login("admin", "wrong");
} catch (InvalidUsernameException e) {
System.out.println(e.getMessage());
} catch (InvalidPasswordException e) {
System.out.println(e.getMessage());
} catch (AccountLockedException e) {
System.out.println(e.getMessage());
} finally {
System.out.println("Login attempt completed");
}
}
}