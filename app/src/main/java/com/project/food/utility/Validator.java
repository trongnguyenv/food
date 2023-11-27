package com.project.food.utility;

import android.util.Patterns;

import java.util.List;

public class Validator {
    /**
     * Method to validate that required user details are provided; they are not null or empty
     * @param name Text representing a user's name
     * @param selectedDiets Selected diets
     * @param selectedHealthPreferences Selected health preferences
     * @return If provided inputs are provided
     */
    public static boolean validateRequiredUserDetailsFormInput(String name, List<String> selectedDiets, List<String> selectedHealthPreferences){
        return !name.isEmpty() && selectedDiets.size() != 0 && selectedHealthPreferences.size() != 0;
    }

    /**
     * Method to validate name; if it has at least 4 characters with no digits
     * @param name Text representing a user's name
     * @return If name is valid
     */
    public static boolean validateNameInput(String name){
        return !(name.length() < 4 || name.matches(".*\\d.*"));
    }

    /**
     * Method to validate email; if it matches Patterns.EMAIL_ADDRESS
     * @param email Text representing an email address
     * @return If email is valid
     */
    public static boolean validateEmailInput(String email) {
        return email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Method to validate password; if it has at least 8 characters with uppercase, lowercase, digits and symbols
     * @param password Text representing password
     * @return If password is valid
     **/
    public static boolean validatePasswordInput(String password) {
        return !(password.length() < 8) && hasDigits(password) && hasUppercase(password)
                && hasLowercase(password) && hasSymbols(password);
    }

    /**
     * Method to validate confirm password; if it is similar to password
     * @param password Text representing password
     * @param confirmPassword Text representing confirm password
     **/
    public static boolean validateConfirmPasswordInput(String password, String confirmPassword) {
        return confirmPassword.equals(password);
    }

    // Utility method to check for presence of digits in text
    private static boolean hasDigits(String text) {
        return text.matches(".*\\d.*");
    }

    // Utility method to check for presence of uppercase in text
    private static boolean hasUppercase(String text) {
        return text.matches(".*[A-Z].*");
    }

    // Utility method to check for presence of lowercase in text
    private static boolean hasLowercase(String text) {
        return text.matches(".*[a-z].*");
    }

    // Utility method to check for presence of symbols in text
    private static boolean hasSymbols(String text) {
        return text.matches(".*[!@#$%^&*()-_+=?><.,;:\"'`~].*");
    }
}
