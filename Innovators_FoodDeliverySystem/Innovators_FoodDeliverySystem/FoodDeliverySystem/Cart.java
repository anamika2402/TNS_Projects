import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(FoodItem foodItem, int quantity) {
        items.put(foodItem, items.getOrDefault(foodItem, 0) + quantity);
    }

    public void removeItem(FoodItem foodItem) {
        items.remove(foodItem);
    }

    public Map<FoodItem, Integer> getItems() {
        return new HashMap<>(items);
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cart:\n");
        double totalCost = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double cost = item.getPrice() * quantity;
            totalCost += cost;
            sb.append(String.format("Food Item: %s, Quantity: %d, Cost: Rs. %.1f%n",
                    item.getName(), quantity, cost));
        }
        sb.append(String.format("Total Cost: Rs. %.1f", totalCost));
        return sb.toString();
    }
}