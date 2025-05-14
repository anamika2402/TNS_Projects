import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private Customer customer;
    private Map<FoodItem, Integer> items;
    private String status;
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>(customer.getCart().getItems());
        this.status = "Pending";
        this.deliveryPerson = null;
        this.deliveryAddress = "Default Address"; // In a real system, this would come from customer's saved addresses
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<FoodItem, Integer> getItems() {
        return new HashMap<>(items);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", items=" + items +
                ", status='" + status + '\'' +
                ", deliveryPerson=" + (deliveryPerson != null ? deliveryPerson : "Not Assigned") +
                '}';
    }
}