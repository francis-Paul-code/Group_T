import java.util.ArrayList;

public class Main {
    static private ArrayList<Item> items = new ArrayList<Item>();

    public static void main(String[] args) {
        // seed data
        seed();

        LanternaDisplay display = new LanternaDisplay();
        ArrayList<String> print = new ArrayList<String>();
        int[] quantities = {9, 2, 2, 4};
        double total = 0;

        for(int i = 0; i < items.size(); i++){
            double lineTotal = items.get(i).calculateTotal(quantities[i]);
            String itm = (items.get(i).getName() + " x" + quantities[i]
                    + " = UGX " + lineTotal);
            print.add(itm);
            total += lineTotal;
        }
        print.add("Total: " + total);

        display.displayManager(print);

    }

    static private void seed() {
        items.add(new PercentDiscountItem("Card", 2000.00, 10,5));
        items.add(new NoDiscountItem("Mug", 1000.00));
        items.add(new FlatDiscountItem("Teddy bear", 25000.00, 3, 3000));
        items.add(new PercentDiscountItem("Flowers (bouquet)", 15000.00, 4, 10));
    }

}
