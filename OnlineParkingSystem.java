
import java.util.Scanner;

public class OnlineParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Online Parking System");
        System.out.println("Please select an option:");
        System.out.println("1. Park Vehicle");
        System.out.println("2. Remove Vehicle");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter vehicle number:");
                String vehicleNumber = scanner.next();
                System.out.println("Enter vehicle type:");
                String vehicleType = scanner.next();
                System.out.println("Vehicle parked successfully");
                break;
            case 2:
                System.out.println("Enter vehicle number:");
                vehicleNumber = scanner.next();
                System.out.println("Vehicle removed successfully");
                break;
            case 3:
                System.out.println("Exiting the system");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        scanner.close();
    }
}