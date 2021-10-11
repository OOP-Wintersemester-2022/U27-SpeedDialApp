package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, Contact> book;

    public PhoneBook() {
        initBook();
    }

    private void initBook() {
        book = new HashMap<String, Contact>();
    }

    public void addContact(String name, String address, String zip, String phoneNumber, String imagePath) {
        Contact newContact = new Contact(name, address, zip, phoneNumber, imagePath);
        book.put(name, newContact);
    }

    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (String name : book.keySet()) {
            contacts.add(book.get(name));
        }
        return contacts;
    }

    public static PhoneBook createFromFile(File contacts) throws FileNotFoundException {
        PhoneBook book = new PhoneBook();
        ArrayList<String> lines = getContactLinesFromFile(contacts);
        for(String line: lines) {
            String[] parts = line.split(",");
            book.addContact(parts[0], parts[1],parts[2], parts[3], parts[4]);
        }
        return book;
    }

    private static ArrayList<String> getContactLinesFromFile(File contacts) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner in = new Scanner(contacts);
        while(in.hasNext()) {
            String currentLine = in.nextLine();
            if(currentLine.equals("name,address,zip,number,imagepath")) {
                continue;
            }
            lines.add(currentLine);
        }
        return lines;
    }
}