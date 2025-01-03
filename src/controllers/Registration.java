package controllers;

import models.User;
import java.util.regex.Pattern;

public class Registration {
    public static final int MAX_ATTEMPTS = 5;
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{8,16}$");

    public static boolean validatePassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
