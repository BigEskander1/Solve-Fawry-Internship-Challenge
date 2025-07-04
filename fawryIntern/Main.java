import java.util.Date;
public class Main {

    public static void main(String[] args) {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000 * 10); 
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); 
       
        // // test expired
        // Product product = new ExpirableProduct("Laptop", 1000, 1, pastDate, true, 0.5);
        // System.out.println(product.isExpired());

                
        Product cheese = new ExpirableProduct("Cheese", 100.0, 10, futureDate, true, 0.2);
        Product biscuits = new ExpirableProduct("Biscuits", 150.0, 5, futureDate, true, 0.7);
        Product tv = new NonExpirableProduct("TV", 1000.0, 3, true, 5.0);
        Product mobile = new NonExpirableProduct("Mobile", 800.0, 7, true, 0.3);
        Product scratchCard = new NonExpirableProduct("Scratch Card", 50.0, 100, false, 0.0);
        Product expiredCheese = new ExpirableProduct("Expired Cheese", 80.0, 2, pastDate, true, 0.2);
        

        CartItem cartItem = new CartItem(cheese, 2);
        CartItem cartItem2 = new CartItem(biscuits, 1);
        CartItem cartItem3 = new CartItem(tv, 3);
        CartItem cartItem4 = new CartItem(mobile, 2);
        CartItem cartItem5 = new CartItem(scratchCard, 5);
        // CartItem cartItem6 = new CartItem(expiredCheese, 1); // expired product to test
        // CartItem cartItem7 = new CartItem(cheese, 12);



        Cart cart = new Cart();
        cart.add(cartItem, 2);
        cart.add(cartItem2, 1);
        cart.add(cartItem3, 3);
        cart.add(cartItem4, 2);
        cart.add(cartItem5, 5);
        // cart.add(cartItem6, 1); // expired product to test
        // cart.add(cartItem7, 12); // quantity to test

        Customer customer = new Customer("fady", 20000);
        Checkout checkout = new Checkout(customer, cart);

        // test not enough balance
        // Customer customer2 = new Customer("bob", 200); 
        // Checkout checkout2 = new Checkout(customer2, cart);
        

        // example with empty cart
        // Cart cart2 = new Cart();
        // Checkout checkout3 = new Checkout(customer, cart2);

       

    }
}