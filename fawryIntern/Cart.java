import java.util.ArrayList;
import java.util.List;
class Cart {
    private List<CartItem> items = new ArrayList<>();
    private ShippableProduct shippableProduct;

    public void add(CartItem cartItem, int quantity) {
        if ( quantity > cartItem.getProduct().getQuantity()) {
            throw new IllegalArgumentException("We do not have this quantity");
        }else if (quantity <= 0) {
            throw new IllegalArgumentException("should be more than 0");
        }

        if( cartItem.getProduct().isExpired()) {
            throw new IllegalArgumentException("Product is expired");
        }
        items.add(new CartItem(cartItem.getProduct(), quantity));
        isShippable(cartItem, quantity);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    // check if product is shippable and add to list
    public void isShippable(CartItem cartItem , int quantity) {
        if (cartItem.getProduct().isShippable()) {
            if (shippableProduct == null) {
                shippableProduct = new ShippableProduct(new ArrayList<>());
            }
            shippableProduct.add(cartItem, quantity);
        }
    }

    public ShippableProduct getShippableProduct() {
        return shippableProduct;
    }
}
