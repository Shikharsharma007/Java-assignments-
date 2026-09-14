import java.util.*;
class ShoppingException extends Exception {
ShoppingException(String m) { super(m); }
}
class ProductNotFoundException extends ShoppingException {
ProductNotFoundException(String m) { super(m); }
}
class CartEmptyException extends ShoppingException {
CartEmptyException(String m) { super(m); }
}
class PaymentFailedException extends ShoppingException {
PaymentFailedException(String m) { super(m); }
}
public class ShoppingCart {
static Map<String, Double> products = new HashMap<>();
static Map<String, Integer> cart = new HashMap<>();
static void add(String name, int qty)
throws ProductNotFoundException {
if (!products.containsKey(name))
throw new ProductNotFoundException("Product not found");
cart.put(name, cart.getOrDefault(name, 0) + qty);
}
static void remove(String name)
throws ProductNotFoundException {
if (!cart.containsKey(name))
throw new ProductNotFoundException("Product not in cart");
cart.remove(name);
}
static double total() throws CartEmptyException {
if (cart.isEmpty())
throw new CartEmptyException("Cart is empty");
double sum = 0;
for (String p : cart.keySet())
sum += products.get(p) * cart.get(p);
return sum;
}
static void pay(double amount)
throws CartEmptyException, PaymentFailedException {
double bill = total();
if (amount < bill)
throw new PaymentFailedException(
"Payment failed: insufficient amount");
System.out.println("Payment successful. Change = "
+ (amount - bill));
}
public static void main(String[] args) {
products.put("Laptop", 50000.0);
products.put("Mouse", 800.0);
try {
add("Laptop", 1);
add("Mouse", 2);
System.out.println("Total = " + total());
pay(52000);
} catch (ShoppingException e) {
System.out.println("Shopping error: " + e.getMessage());
}
}
}