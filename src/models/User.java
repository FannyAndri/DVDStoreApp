package models;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public abstract void displayRole();
    
    public abstract void addDVD(String name, String type, double price); 
    public abstract void deleteDVD(String id); 
    public abstract void viewAvailableDVDs(); 
    public abstract void searchByName(String name);
}
