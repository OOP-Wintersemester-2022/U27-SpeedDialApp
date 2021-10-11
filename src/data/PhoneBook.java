package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, Entry> book;

    public PhoneBook() {
        initBook();
    }

    private void initBook() {
        book = new HashMap<String, Entry>();
    }

    public void addEntry(String name, String areaCode, String number, String imagePath) {
        Entry newEntry = new Entry(name, areaCode, number, imagePath);
        book.put(name, newEntry);
    }

    public ArrayList<Entry> getEntries() {
        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (String name : book.keySet()) {
            entries.add(book.get(name));
        }

        return entries;
    }

    public static PhoneBook createFromFile(File contacts) throws FileNotFoundException {
        PhoneBook book = new PhoneBook();
        ArrayList<String> lines = getContactLinesFromFile(contacts);

        for(String line: lines) {
            String[] parts = line.split(",");
            book.addEntry(parts[0],parts[1],parts[2], parts[3]);
        }

        return book;
    }

    private static ArrayList<String> getContactLinesFromFile(File contacts) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner in = new Scanner(contacts);

        while(in.hasNext()) {
            String currentLine = in.nextLine();
            if(currentLine.equals("name,areaCode,number,imagepath")) {
                continue;
            }
            lines.add(currentLine);
        }

        return lines;
    }
}