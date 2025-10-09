package Model;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Double> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }
    public void addItem(String item, double price) {
        items.put(item,price);
    }
    public void removeItem(String item) {
        items.remove(item);
    }
    public double calculateTotal(){
        double total = 0;
        for (double price : items.values()) {
            total += price;
        }
        return total;
    }
    public int getItemCount(){
        return items.size();
    }
}
