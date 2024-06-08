package addressbook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        String filename = "contacts.txt";

        addressBook.load(filename);

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. List contacts");
            System.out.println("2. Create new contact");
            System.out.println("3. Delete contact");
            System.out.println("4. Save and exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (option) {
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    addressBook.create(phone, name);
                    break;
                case 3:
                    System.out.print("Enter phone number to delete: ");
                    phone = scanner.nextLine();
                    addressBook.delete(phone);
                    break;
                case 4:
                    addressBook.save(filename);
                    System.out.println("Contacts saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
