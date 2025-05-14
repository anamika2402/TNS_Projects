import java.util.*;

public class FoodDeliverySystem {
    private List<Restaurant> restaurants;
    private List<Customer> customers;
    private List<DeliveryPerson> deliveryPersons;
    private List<Order> orders;
    private int nextOrderId;

    public FoodDeliverySystem() {
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.deliveryPersons = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.nextOrderId = 1;
    }

    // Admin functionalities
    public void addRestaurant(int id, String name) {
        restaurants.add(new Restaurant(id, name));
        System.out.println("Restaurant added successfully!");
    }

    public void addFoodItemToRestaurant(int restaurantId, int foodItemId, String name, double price) {
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.addFoodItem(new FoodItem(foodItemId, name, price));
            System.out.println("Food item added successfully!");
        } else {
            System.out.println("Restaurant not found!");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodItemId);
            System.out.println("Food item removed successfully!");
        } else {
            System.out.println("Restaurant not found!");
        }
    }

    public void viewRestaurantsAndMenus() {
        System.out.println("Restaurants and Menus:");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
            for (FoodItem item : restaurant.getMenu()) {
                System.out.println("- Food Item ID: " + item.getId() + ", Name: " + item.getName() + 
                                 ", Price: Rs. " + item.getPrice());
            }
        }
    }

    public void addDeliveryPerson(int id, String name, long contactNo) {
        deliveryPersons.add(new DeliveryPerson(id, name, contactNo));
        System.out.println("Delivery person added successfully!");
    }

    public void assignDeliveryPerson(int orderId, int deliveryPersonId) {
        Order order = findOrderById(orderId);
        DeliveryPerson deliveryPerson = findDeliveryPersonById(deliveryPersonId);
        
        if (order != null && deliveryPerson != null) {
            order.setDeliveryPerson(deliveryPerson);
            System.out.println("Delivery person assigned to order successfully!");
        } else {
            System.out.println("Order or delivery person not found!");
        }
    }

    // Customer functionalities
    public void addCustomer(int userId, String username, long contactNo) {
        customers.add(new Customer(userId, username, contactNo));
        System.out.println("Customer created successfully!");
    }

    public void addFoodToCart(int customerId, int restaurantId, int foodItemId, int quantity) {
        Customer customer = findCustomerById(customerId);
        Restaurant restaurant = findRestaurantById(restaurantId);
        
        if (customer != null && restaurant != null) {
            FoodItem foodItem = findFoodItemInRestaurant(restaurant, foodItemId);
            if (foodItem != null) {
                customer.getCart().addItem(foodItem, quantity);
                System.out.println("Food item added to cart!");
            } else {
                System.out.println("Food item not found!");
            }
        } else {
            System.out.println("Customer or restaurant not found!");
        }
    }

    public void viewCart(int customerId) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            System.out.println(customer.getCart());
        } else {
            System.out.println("Customer not found!");
        }
    }

    public void placeOrder(int customerId) {
        Customer customer = findCustomerById(customerId);
        if (customer != null && !customer.getCart().getItems().isEmpty()) {
            Order order = new Order(nextOrderId++, customer);
            orders.add(order);
            customer.getCart().clear();
            System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
        } else {
            System.out.println("Customer not found or cart is empty!");
        }
    }

    public void viewOrders() {
        System.out.println("Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // Helper methods
    private Restaurant findRestaurantById(int id) {
        return restaurants.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private Customer findCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getUserId() == id)
                .findFirst()
                .orElse(null);
    }

    private DeliveryPerson findDeliveryPersonById(int id) {
        return deliveryPersons.stream()
                .filter(d -> d.getDeliveryPersonId() == id)
                .findFirst()
                .orElse(null);
    }

    private Order findOrderById(int id) {
        return orders.stream()
                .filter(o -> o.getOrderId() == id)
                .findFirst()
                .orElse(null);
    }

    private FoodItem findFoodItemInRestaurant(Restaurant restaurant, int foodItemId) {
        return restaurant.getMenu().stream()
                .filter(f -> f.getId() == foodItemId)
                .findFirst()
                .orElse(null);
    }
}
