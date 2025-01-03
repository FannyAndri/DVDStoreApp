package models;
import controllers.DVDStore;

public class Admin extends User implements DVDOperations {
    private DVDStore store;

    public Admin(String username, String password, DVDStore store) {
        super(username, password);
        this.store = store;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Admin");
    }

    @Override
    public void addDVD(String name, String type, double price) {
        store.addDVD(name, type, price);
    }

    @Override
    public void deleteDVD(String id) {
        store.deleteDVD(id);
    }

    @Override
    public void viewAvailableDVDs() {
        store.viewAvailableDVDs();
    }

    @Deprecated
    public void searchByName(String name) {
        store.searchByName(name);
    }

    @Override
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
                System.out.println("Kriteria pencarian tidak valid. Gunakan: name, id, atau type.");
        }
    }
}
