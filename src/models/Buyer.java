package models;
import controllers.DVDStore;
import java.util.ArrayList;

public class Buyer extends User implements DVDOperations {
    private DVDStore store;

    public Buyer(String username, String password, DVDStore store) {
        super(username, password);
        this.store = store;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Buyer");
    }

    @Override
    public void addDVD(String name, String type, double price) {
        System.out.println("Buyers cannot add DVDs.");
    }

    @Override
    public void deleteDVD(String id) {
        System.out.println("Buyers cannot delete DVDs.");
    }

    @Override
    public void viewAvailableDVDs() {
        store.viewAvailableDVDs();
    }

    @Override
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

    public void purchaseDVDs(ArrayList<String> dvdIDs) {
        ArrayList<DVD> purchasedDVDs = new ArrayList<>();
        for (String id : dvdIDs) {
            DVD dvd = store.getDVDById(id);
            if (dvd != null) {
                purchasedDVDs.add(dvd);
            } else {
                System.out.println("DVD dengan ID " + id + " tidak ditemukan.");
            }
        }

        if (!purchasedDVDs.isEmpty()) {
            double totalPrice = store.calculateTotalPrice(purchasedDVDs);
            System.out.println("Total harga yang harus dibayar: " + totalPrice);
        } else {
            System.out.println("Tidak ada DVD yang valid untuk dibeli.");
        }
    }
}
