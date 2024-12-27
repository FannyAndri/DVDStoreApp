package controllers;

import models.DVD;
import models.MusicDVD;
import models.FilmDVD;
import java.util.ArrayList;

public class DVDStore {
    private ArrayList<DVD> inventory = new ArrayList<>();
    private int dvdCounter = 1;

    public void addDVD(String name, String type, double price) {
        DVD newDVD;
        if (type.equalsIgnoreCase("music")) {
            newDVD = new MusicDVD(name, dvdCounter++, price);
        } else {
            newDVD = new FilmDVD(name, dvdCounter++, price);
        }
        inventory.add(newDVD);
        System.out.println("DVD added: " + newDVD.getDetails());
    }

    public void deleteDVD(String id) {
        DVD dvdToRemove = getDVDById(id);
        if (dvdToRemove != null) {
            inventory.remove(dvdToRemove);
            System.out.println("DVD with ID " + id + " has been deleted.");
        } else {
            System.out.println("DVD with ID " + id + " not found.");
        }
    }

    public void viewAvailableDVDs() {
        if (inventory.isEmpty()) {
            System.out.println("No DVDs available.");
        } else {
            for (DVD dvd : inventory) {
                System.out.println(dvd.getDetails());
            }
        }
    }

    public void searchByName(String name) {
        for (DVD dvd : inventory) {
            if (dvd.getName().equalsIgnoreCase(name)) {
                System.out.println(dvd.getDetails());
            }
        }
    }

    public void searchByID(String id) {
        for (DVD dvd : inventory) {
            if (dvd.getId().equals(id)) {
                System.out.println(dvd.getDetails());
            }
        }
    }

    public void searchByType(String type) {
        for (DVD dvd : inventory) {
            if (dvd.getType().equalsIgnoreCase(type)) {
                System.out.println(dvd.getDetails());
            }
        }
    }

    public double calculateTotalPrice(ArrayList<DVD> purchasedDVDs) {
        double total = 0.0;
        for (DVD dvd : purchasedDVDs) {
            total += dvd.getPrice();
        }
        if (purchasedDVDs.size() >= 3 ) {
            total *= 0.7; 
        }
        return total;
    }

    public DVD getDVDById(String id) {
        for (DVD dvd : inventory) {
            if (dvd.getId().equals(id)) {
                return dvd;
            }
        }
        return null;
    }
}