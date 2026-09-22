public class Item {
    private String name;
    private Double price;
    private PercentDiscountItem discount;

    public Item(String name, Double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }

        this.name = name;
        this.price = price;

    }

    public double calculateTotal(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        return price * quantity;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnit_price() {
        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }

}
