/*
Name: Jordan Belinsky
File: BadProperty.java
Purpose: Handle throwing exceptions when illegal inputs or parameters are utilized.
*/

public class BadProperty extends Exception {

    // Initialize constructor for the class
    public BadProperty(String message) {
        super(message);
    }
}
