package data;

public class Entry {

    private String name;
    private String areaCode;
    private String number;
    private String imagePath;

    public Entry(String name, String areaCode, String number, String imagePath) {
        this.name = name;
        this.areaCode = areaCode;
        this.number = number;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getFullNumber() {
        return  "AreaCode:" + getAreaCode() + ", Number.:" + getNumber();
    }

}
