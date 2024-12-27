package models;

import controllers.DVDStore;
import models.DVD;
import java.util.ArrayList;

public class Buyer extends User {
    private DVDStore store;

    public Buyer(String username, String password, DVDStore store) {
        super(username, password);
        this.store = store;
    }

    public void purchaseDVDs(ArrayList<String> dvdIDs) {
        ArrayList<DVD> purchasedDVDs = new ArrayList<>();
        for (String id : dvdIDs) {
            DVD dvd = store.getDVDById(id);
            if (dvd != null) {
                purchasedDVDs.add(dvd);
            } else {
                System.out.println("DVD with ID " + id + " not found.");
            }
        }
        double totalPrice = store.calculateTotalPrice(purchasedDVDs);
        System.out.println("Total price after discount (if applicable): " + totalPrice);
    }

    public void viewAvailableDVDs() {
        store.viewAvailableDVDs();
    }
}
