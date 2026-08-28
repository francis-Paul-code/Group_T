public class Item {
    private String name;
    private String description;
    private String category;
    private Integer unit_price;
    private boolean discounted = false;
    private Discount discount;

    public Item(String name, String category, Integer unit_price) {
        this.name = name;
        this.category = category;
        this.unit_price = unit_price;
        this.description = "";

    }

    // discounts

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(String description, Integer rate, Double discounted_amount, Integer prerequisite_purchase) {
        Discount discount = new Discount(description, rate, discounted_amount, prerequisite_purchase);
        this.discount = discount;
        this.discounted = true;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {

        this.unit_price = unit_price;
    }

}
