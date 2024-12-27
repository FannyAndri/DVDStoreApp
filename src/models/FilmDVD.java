package models;

public class FilmDVD extends DVD {
    public FilmDVD(String name, int order, double price) {
        super(name, order, "Film", price);
    }

    @Override
    public String getDetails() {
        return "Film DVD [Name: " + getName() + ", ID: " + getId() + ", Price: " + getPrice() + "]";
    }
}