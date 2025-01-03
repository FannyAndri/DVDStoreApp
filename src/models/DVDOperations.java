package models;

public interface DVDOperations {
    void addDVD(String name, String type, double price);
    void deleteDVD(String id);
    void viewAvailableDVDs();
    void searchDVD(String criteria, String value);
}
