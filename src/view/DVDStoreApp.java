package view;

import controllers.DVDStore;
import controllers.Registration;
import models.Admin;
import models.Buyer;
import models.User;
import java.util.ArrayList;
import java.util.Scanner;

public class DVDStoreApp {

    private static ArrayList<User> registeredUsers = new ArrayList<>();

    public static void main(String[] args) {
        DVDStore store = new DVDStore();
        Admin admin = new Admin("admin", "admin123", store);
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== Welcome to the DVD Store! by Kelompok 4 ======");
        System.out.println("");

        while (true) {
            System.out.print("Login as (admin/buyer/register): ");
            String role = scanner.nextLine();

            if (role.equalsIgnoreCase("register")) {
                registerUser(scanner);
                continue;
            }

            if (role.equalsIgnoreCase("buyer")) {
                loginAsBuyer(scanner, store);
                continue;
            }

            if (role.equalsIgnoreCase("admin")) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    System.out.println("Admin logged in.");
                    adminMenu(admin, scanner);
                } else {
                    System.out.println("Invalid admin credentials.");
                }
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Buyer newUser = new Buyer(username, password, null);
        registeredUsers.add(newUser);
        System.out.println("Registration successful! Please login as buyer to access features.");
    }

    private static void loginAsBuyer(Scanner scanner, DVDStore store) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : registeredUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Buyer logged in.");
                Buyer buyer = new Buyer(username, password, store);
                buyerMenu(buyer, scanner);
                return;
            }
        }
        System.out.println("Invalid buyer credentials.");
    }

    private static void adminMenu(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("1. Add DVD\n2. Delete DVD\n3. List DVD\n4. Search DVD\n5. Logout");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter DVD name: ");
                String name = scanner.nextLine();
                System.out.print("Enter DVD type (music/film): ");
                String type = scanner.nextLine();
                System.out.print("Enter DVD price: ");
                double price = Double.parseDouble(scanner.nextLine());
                admin.addDVD(name, type, price);
            } else if (choice.equals("2")) {
                System.out.print("Enter DVD ID to delete: ");
                String id = scanner.nextLine();
                admin.deleteDVD(id);
            } else if (choice.equals("3")) {
                admin.viewAvailableDVDs();
            } else if (choice.equals("4")) {
                System.out.print("Search by (name/id/type): ");
                String criteria = scanner.nextLine();
                System.out.print("Enter value: ");
                String value = scanner.nextLine();
                admin.searchDVD(criteria, value);
            } else if (choice.equals("5")) {
                admin.searchByName(choice);
            } else if (choice.equals("6")) {
                System.out.print("Admin logged out");
                break;
            }
        }
    }

    private static void buyerMenu(Buyer buyer, Scanner scanner) {
        while (true) {
            System.out.println("1. Purchase DVDs\n2. View Available DVDs\n3. Logout");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                ArrayList<String> dvdIDs = new ArrayList<>();
                System.out.println("Enter DVD IDs to purchase (type 'done' to finish): ");
                while (true) {
                    String id = scanner.nextLine();
                    if (id.equalsIgnoreCase("done")) break;
                    dvdIDs.add(id);
                }
                buyer.purchaseDVDs(dvdIDs);
            } else if (choice.equals("2")) {
                buyer.viewAvailableDVDs();
            } else if (choice.equals("3")) {
                break;
            }
        }
    }
}
