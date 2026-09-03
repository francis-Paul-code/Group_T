import java.util.ArrayList;
import java.util.Scanner;

public class GroupT_BusinessSimulator {
    public record Discount(int purchase_requirement, String details){}
    public record Item(String name, double price, int quantity, Discount discount) {
    }
    static Scanner  sc = new Scanner(System.in);
    static ArrayList<Item> items = new ArrayList<Item>();

    static void main(String[] args) {

        // adding items
        seed();

        //printing the price list using a loop
        printPriceList();

        // choosing items
//        ArrayList<int> choices = new ArrayList<int>();
//        while(choices.size() < 3){
//            int index = inputHelper();
//            Item i = items.get(index - 1);
//            System.out.printf("Your item is %s costs %d and the current stock is %d",i.name,(int) i.price,i.quantity);
//
//            choices.add(index);
//        }


        //calculating subtotal for each item
        double sub1 = calculateSubtotal(0);
        double sub2 = calculateSubtotal(1);
        double sub3 = calculateSubtotal(2);
        double sub4 = calculateSubtotal(3);

        //grand total
        double grandTotal = sub1 + sub2 + sub3 + sub4;

        //print the receipt
        printReceipt( sub1, sub2, sub3, sub4, grandTotal);
    }

    // seeding initial data
    static public void seed() {
        items.add(new Item("Card", 2000.00, 9, new Discount(10, "5% discount applied")));
        items.add(new Item("Mug", 1000.00, 2, new Discount(0, "no discount")));
        items.add(new Item("Teddy bear", 25000.00, 2,  new Discount(3, "3000 UGX discount applied")));
        items.add(new Item("Flowers (bouquet)", 15000.00, 4,  new Discount(4, "10% discount applied")));
    }

    //display price list using loop
    public static void printPriceList() {
        System.out.println("================ CHERISH GIFT SHOP ================");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + " . " + items.get(i).name + ": UGX " + items.get(i).price);
        }
        System.out.println("===================================================");
    }

    // item Selection
    public static int inputHelper(){
        System.out.print("SELECT ITEM: ");
        double selection = sc.nextInt();
        sc.nextLine();
        return (int) selection;
    }

    //calculating subtotal and applying discount if able
    public static double calculateSubtotal(int itemIndex) {
        Item i = items.get(itemIndex);
        double subtotal = i.price * i.quantity;
        if (itemIndex == 0) {
            //card: 10 or more cards, 5% discount
            if (i.quantity >= 10) {
                subtotal = (subtotal * 0.05);
            }

        } else if (itemIndex == 1) {
            // Mug: No deal
        } else if (itemIndex == 2) {
            if (i.quantity >= 3) {
                subtotal = (subtotal - 3000.0);
            }
        } else if (itemIndex == 3) {
            if (i.quantity >= 4) {
                subtotal = subtotal - (subtotal * 0.10);
            }
        }
        return subtotal;
    }

    //printing an itemized receipt
    public static void printReceipt( double s1, double s2, double s3, double s4, double grandTotal) {
        System.out.println("============== RECEIPT ===============");
        double[] temp = {s1,s2,s3,s4};
        if(temp.length != items.size()){
            throw new RuntimeException();
        }
        for (int i = 0; i < items.size(); i++) {
            Item itm = items.get(i);

            if(itm.discount.purchase_requirement == 0){
                System.out.println(itm.name + " x" + itm.quantity + "= UGX " + temp[i] + "(No discount )");
                continue;
            }
            String note1 = (itm.quantity > itm.discount.purchase_requirement) ? itm.discount.details : String.format("no discount - fewer than %d", itm.discount.purchase_requirement );
            System.out.println(itm.name + " x" + itm.quantity + "= UGX " + temp[i] + "(" + note1 + ")");
        }
        System.out.println("======================================");
        System.out.println("GRAND TOTAL: UGX " + grandTotal);
    }

}