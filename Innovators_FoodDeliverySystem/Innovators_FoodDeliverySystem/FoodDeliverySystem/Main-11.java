import java.util.Scanner;

public class Main {
    private static FoodDeliverySystem system;
    private static Scanner scanner;

    public static void main(String[] args) {
        system = new FoodDeliverySystem();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using the Food Delivery System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Restaurant Name: ");
                    String restaurantName = scanner.nextLine();
                    system.addRestaurant(restaurantId, restaurantName);
                    break;

                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int restId = scanner.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int foodId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Food Item Name: ");
                    String foodName = scanner.nextLine();
                    System.out.print("Enter Food Item Price: ");
                    double price = scanner.nextDouble();
                    system.addFoodItemToRestaurant(restId, foodId, foodName, price);
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int rId = scanner.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int fId = scanner.nextInt();
                    system.removeFoodItemFromRestaurant(rId, fId);
                    break;

                case 4:
                    system.viewRestaurantsAndMenus();
                    break;

                case 5:
                    system.viewOrders();
                    break;

                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryPersonId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Delivery Person Name: ");
                    String deliveryPersonName = scanner.nextLine();
                    System.out.print("Enter Contact No.: ");
                    long deliveryPersonContact = scanner.nextLong();
                    system.addDeliveryPerson(deliveryPersonId, deliveryPersonName, deliveryPersonContact);
                    break;

                case 7:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter Delivery Person ID: ");
                    int dpId = scanner.nextInt();
                    system.assignDeliveryPerson(orderId, dpId);
                    break;

                case 8:
                    System.out.println("Exiting Admin Module");
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void customerMenu() {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Contact No.: ");
                    long contactNo = scanner.nextLong();
                    system.addCustomer(userId, username, contactNo);
                    break;

                case 2:
                    system.viewRestaurantsAndMenus();
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = scanner.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int foodItemId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    system.addFoodToCart(customerId, restaurantId, foodItemId, quantity);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int cId = scanner.nextInt();
                    system.viewCart(cId);
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int custId = scanner.nextInt();
                    system.placeOrder(custId);
                    break;

                case 6:
                    system.viewOrders();
                    break;

                case 7:
                    System.out.println("Exiting Customer Module");
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}