package users;

import services.DVDStore;

public class Admin extends User {
    private DVDStore store;

    public Admin(String username, String password, DVDStore store) {
        super(username, password);
        this.store = store;
    }

    public void addDVD(String name, String type, double price) {
        store.addDVD(name, type, price);
    }

    public void deleteDVD(String id) {
        store.deleteDVD(id);
    }

    public void viewAvailableDVDs() {
        store.viewAvailableDVDs();
    }

    public void searchDVD(String criteria, String value) {
        switch (criteria.toLowerCase()) {
            case "name":
                store.searchByName(value);
                break;
            case "id":
                store.searchByID(value);
                break;
            case "type":
                store.searchByType(value);
                break;
            default:
                System.out.println("Invalid search criteria.");
        }
    }
}