package controllers;

import models.User;
import java.util.regex.Pattern;

public class Registration {
    public static final int MAX_ATTEMPTS = 5;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,16}$");

    public static boolean validatePassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static User registerUser(String username, String password) {
        if (validatePassword(password)) {
            return new User(username, password);
        } else {
            System.out.println("Password must be 8-16 characters long, contain at least one uppercase letter and one digit.");
            return null;
        }
    }
}