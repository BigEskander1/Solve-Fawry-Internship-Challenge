import java.util.ArrayList;
import java.util.List;

interface Shippable {
    String getName();
    double getWeight();
}
class ShippableProduct implements Shippable {
    private List<CartItem> items = new ArrayList<>();


    public ShippableProduct(List<CartItem> items) {
        this.items = items;
    }

    public void add(CartItem cartItem , int quantity) {
        items.add(new CartItem(cartItem.getProduct(), quantity));
    }

    @Override
    public double getWeight() {
        double weight = 0;
        for (CartItem item : items) {
            weight += item.getProduct().getWeight();
        }
        return weight;
    }

    @Override
    public String getName() {
        String name = " ";
        for (CartItem item : items) {
            name += item.getProduct().getName();
        }

        return name ;
    }

    public List<CartItem> getItems() {
        return items;
    }
}