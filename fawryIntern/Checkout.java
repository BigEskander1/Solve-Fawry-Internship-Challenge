
import java.util.List;

class  Checkout {
    private Cart cart;    
    private Customer customer;   
    List<CartItem> shippableProducts; 
    private double subTotal = 0; 
    private double totalWeight = 0;  
    private double shippingFee  = 0;  
    private double total  = 0;  

    public Checkout(Customer customer, Cart cart) {
        this.cart = cart;
        this.customer = customer;
        this.shippableProducts = cart.getShippableProduct().getItems();
        calculateSubTotal();
        calculateTotalWeight();
        calculateShippingFee();
        calculateTotal();
        printReceipt();
    }
        

    // double shippingFee = totalWeight * 27.27;

    public void calculateSubTotal() {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }
        for (CartItem item : cart.getItems()) {
           this.subTotal  += item.getProduct().getPrice() * item.getQuantity();
        }
    }

    public void calculateTotalWeight() {
        for (CartItem item : cart.getItems()) {
           if (item.getProduct().isShippable()) 
           totalWeight  += item.getProduct().getWeight() * item.getQuantity();
        }

        totalWeight = Math.round(totalWeight * 100.0) / 100.0;
    }
    public void calculateShippingFee () {
        shippingFee =   Math.round(totalWeight * 27.27 * 100.0) / 100.0;
    }
    public void calculateTotal () {
        total = subTotal + shippingFee;
        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Not enough balance");
        }else {
            customer.setBalance(customer.getBalance() - total);
        }
    }

    public void printReceipt() {
        System.out.println("\n console output");
        System.out.println("_______________");

        for (CartItem item : cart.getItems()) {
            System.out.print(item.getProduct().getName() + 
            " x " + item.getQuantity() +
             " : $" + item.getTotalPrice() 
             );

            if (item.getProduct().isShippable()) {
                System.out.print(" , weight: " + item.getProduct().getWeight()*item.getQuantity() + "kg");
            }

            System.out.println();
        }
        System.err.println("\n----------------- \n");
        System.out.println("Sub Total : $" + subTotal);
        System.out.println("Total Weight : " + totalWeight + "kg");
        System.out.println("Shipping Fee : $" + shippingFee);
        System.out.println("Total : $" + total );
        System.out.println("Balance after Payment : $" + customer.getBalance());

    }
}