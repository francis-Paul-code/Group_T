public class Discount {
    private String description;
    private Integer rate; // percentage rate
    private Double discounted_amount;
    private Integer prerequisite_purchase;

    public Discount (String description,  Integer rate, Double discounted_amount, Integer prerequisite_purchase) {
        this.description = description;
        this.rate = rate;
        this.discounted_amount = discounted_amount;
        this.prerequisite_purchase = prerequisite_purchase;
    }

    // getters and setters
    public String getDescription() { return description; }
    public Integer getRate() { return rate; }
    public Double getDiscountedAmount() { return discounted_amount; }
    public Integer getPrerequisitePurchase() { return prerequisite_purchase; }
    public void setDescription(String description) { this.description = description; }
    public void setRate(Integer rate) { this.rate = rate; }
    public void setDiscountedAmount(Double discounted_amount) {this.discounted_amount = discounted_amount; }
    public void setPrerequisite_purchase(Integer pre_purchase) { this.prerequisite_purchase = pre_purchase; }
}
