class NonExpirableProduct extends Product {
    private double weight; 
    private boolean shippable;

    public NonExpirableProduct(String name, double price, int quantity , boolean shippable , double weight) {
        super(name, price, quantity);
        this.weight = weight;
        this.shippable = shippable;
    }

    @Override
    public boolean isExpired() {
       return false;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public boolean isShippable() {
        return shippable;
    }

}
