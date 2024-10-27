package Models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<DigitalVideoDisc> qtyOrdered = new ArrayList<>();
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int currentQty = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (currentQty < MAX_NUMBER_ORDERED) {
            qtyOrdered.add(dvd);
            itemOrdered[currentQty] = dvd;
            currentQty++;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < currentQty; i++) {
            if (itemOrdered[i].equals(dvd)) {
                qtyOrdered.remove(dvd);

                for (int j = i; j < currentQty - 1; j++) {
                    itemOrdered[j] = itemOrdered[j + 1];
                }

                itemOrdered[currentQty - 1] = null;
                currentQty--;
                found = true;
                System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed from the cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("NOT FOUND " + dvd.getTitle());
        }
    }

    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc dvd : qtyOrdered) {
            total += dvd.getCost();
        }
        return total;
    }

    public static void main(String[] args) {
        Cart cart = new Cart(); // Create an instance of Cart

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);
        
        //cart.removeDigitalVideoDisc(dvd2);
        
        System.out.println("Total cost: " + String.format("%.2f", cart.totalCost()));
    }
}
