package addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contacts;

    public AddressBook() {
        contacts = new HashMap<>();
    }

    public void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    public void save(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println("Phone: " + entry.getKey() + ", Name: " + entry.getValue());
            }
        }
    }

    public void create(String phone, String name) {
        contacts.put(phone, name);
        System.out.println("Contact added: Phone: " + phone + ", Name: " + name);
    }

    public void delete(String phone) {
        if (contacts.remove(phone) != null) {
            System.out.println("Contact deleted: Phone: " + phone);
        } else {
            System.out.println("Contact not found: Phone: " + phone);
        }
    }
}
