package models;

public class MusicDVD extends DVD {
    public MusicDVD(String name, int order, double price) {
        super(name, order, "Music", price);
    }

    @Override
    public String getDetails() {
        return "Music DVD [Name: " + getName() + ", ID: " + getId() + ", Price: " + getPrice() + "]";
    }
}
