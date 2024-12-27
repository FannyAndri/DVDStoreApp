package models;

public class DVD {
    private String name;
    private String id;
    private String type;
    private double price;

    public DVD(String name, int order, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.id = generateID(order, name, type);
    }

    private String generateID(int order, String name, String type) {
        int letterOrder = Character.toLowerCase(name.charAt(0)) - 'a' + 1;
        String typeCode = type.equalsIgnoreCase("music") ? "11" : "12";
        return String.format("%d%d%s", order, letterOrder, typeCode);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return "DVD [Name: " + name + ", ID: " + id + ", Type: " + type + ", Price: " + price + "]";
    }
}