/*
    Name: Jordan Belinsky
    File: IllegalVehicle.java
    Purpose: Defines the IllegalVehicle class which handles exceptions throughout all of the other classes.
*/

public class IllegalVehicle extends Exception {

    // Constructor for the class
    public IllegalVehicle (String message) {
        // Throw error message passed through the class call
        super(message);
    }
}

