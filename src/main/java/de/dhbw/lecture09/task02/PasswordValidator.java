package de.dhbw.lecture09.task02;

public class PasswordValidator {

    public boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password darf nicht null sein");
        }

        boolean hasMinLength = password.length() >= 8;
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasUpperCase = password.matches(".*[A-Z].*");

        return hasMinLength && hasDigit && hasUpperCase;
    }
}