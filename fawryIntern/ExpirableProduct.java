import java.util.Date;
class ExpirableProduct extends Product {
    private Date expirationDate;
    private double weight; 
    private boolean shippable;

    public ExpirableProduct(String name, double price, int quantity , Date expirationDate ,boolean Shippable, double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
        this.shippable = Shippable;
    }
    
    @Override
    public boolean isExpired() {
        // compare current date with expiration date
       return this.expirationDate.before(new Date());
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public boolean isShippable() {
        return shippable;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}