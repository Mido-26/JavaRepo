package DeliverySystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParcelManager manager = new ParcelManager();
        DeliveryService deliveryService = new DeliveryService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        showWelcomeMessage();

        while (running) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1 -> addParcel(scanner, manager);
                case 2 -> viewParcels(manager);
                case 3 -> startDelivery(manager, deliveryService);
                case 4 -> cancelParcel(scanner, manager);
                case 5 -> {
                    System.out.println("Exiting the Delivery System. Thank you for using our service!");
                    running = false;
                }
                default -> System.out.println("⚠️ Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
        System.out.println("Have a great day!");
    }

    private static void showWelcomeMessage() {
        System.out.println("==================================================");
        System.out.println("🚚 Welcome to the Parcel Delivery System!");
        System.out.println("Manage, process, and deliver parcels efficiently.");
        System.out.println("==================================================");
    }

    private static void printMenu() {
        System.out.println("\n----------- 📋 Main Menu -----------");
        System.out.println("1. ➕ Add Parcel");
        System.out.println("2. 📦 View Your Parcels");
        System.out.println("3. 🚀 Start Delivering Parcels");
        System.out.println("4. ❌ Cancel Parcel");
        System.out.println("5. 🔚 Exit");
        System.out.println("------------------------------------");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice (1-5): ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }

    private static void addParcel(Scanner scanner, ParcelManager manager) {
        scanner.nextLine(); // clear buffer

        System.out.print("Parcel ID: ");
        String id = scanner.nextLine();

        System.out.print("Sender Name: ");
        String sender = scanner.nextLine();

        System.out.print("Receiver Name: ");
        String receiver = scanner.nextLine();

        System.out.print("Pickup Location: ");
        String pickup = scanner.nextLine();

        System.out.print("Delivery Location: ");
        String delivery = scanner.nextLine();


        System.out.print("Weight (kg): ");
        double weight = getValidDouble(scanner);
        scanner.nextLine();

        System.out.print("Priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        manager.addParcel(new Parcel(id, sender, receiver, pickup, delivery, weight, priority));
        System.out.println("✅ Parcel added successfully!");
    }

    private static void viewParcels(ParcelManager manager) {
        var parcels = manager.getSortedParcels();
        if (parcels.isEmpty()) {
            System.out.println("📭 No parcels to display.");
        } else {
            System.out.println("📦 Your Parcels (sorted by priority):");
            for (Parcel p : parcels) {
                System.out.println(" - " + p);
            }
        }
    }

    private static void startDelivery(ParcelManager manager, DeliveryService deliveryService) {
        if (!manager.hasPendingParcels()) {
            System.out.println("📭 No parcels to deliver.");
            return;
        }

        System.out.println("🚚 Starting delivery...");

        while (manager.hasPendingParcels()) {
            Parcel toDeliver = manager.processNextParcel();

            if (toDeliver.getWeight() <= 5) {
                deliveryService.setStrategy(new BikeDelivery());
            } else {
                deliveryService.setStrategy(new TruckDelivery());
            }
            deliveryService.deliver(manager.deliverNextParcel());
        }
        System.out.println("✅ All parcels delivered!");
    }

    private static void cancelParcel(Scanner scanner, ParcelManager manager) {
        scanner.nextLine(); // clear buffer
        System.out.print("Enter Parcel ID to cancel: ");
        String cancelId = scanner.nextLine();
        boolean removed = manager.cancelParcel(cancelId);

        if (removed) {
            System.out.println(" ✅ Parcel " + cancelId + " has been cancelled.");
        } else {
            System.out.println("❌ Parcel " + cancelId + " not found or already processed.");
        }
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("⚠️ Invalid input. Please enter a valid number: ");
                scanner.nextLine();
            }
        }
    }
}
