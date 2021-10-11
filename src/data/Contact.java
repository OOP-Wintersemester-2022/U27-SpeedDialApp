package data;

public class Contact {

    public final String name;
    public final String address;
    public final String zipCode;
    public final String phoneNumber;
    public final String imagePath;

    public Contact(String name, String address, String zipCode, String phoneNumber, String imagePath) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.imagePath = imagePath;
    }

}
