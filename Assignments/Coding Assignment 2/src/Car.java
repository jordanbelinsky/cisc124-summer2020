/*
    Name: Jordan Belinsky
    File: Car.java
    Purpose: Defines the Car class which is inherited from parent class Vehicle.
*/

public class Car extends Vehicle {

    // Instance variables
    private int numSeats;
    private boolean isSUV;

    // Constructor for the class
    public Car(int regNum, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber, int numSeats, boolean isSUV) throws IllegalVehicle {
        super(regNum, owner, odometerReading, make, model, year, numWheels, plateNumber);
        setNumSeats(numSeats);
        setSUV(isSUV);
    }

    // toString to allow for formatting while pulling the parent class instance variables
    @Override
    public String toString() {
        return "Car { " +
                super.toString() +
                ", numSeats=" + numSeats +
                ", isSUV=" + isSUV +
                " }";
    }

    /*
    Accessor methods for each instance variable
    */
    public int getNumSeats() {
        // Fetches the number of seats
        return numSeats;
    }

    public boolean isSUV() {
        // Fetches the state of SUV
        return isSUV;
    }

    /*
    Mutator methods for each instance variable
    */
    public void setNumSeats(int numSeats) {
        // Sets the current number of seats
        this.numSeats = numSeats;
    }

    public void setSUV(boolean SUV) {
        // Sets the current state of SUV
        isSUV = SUV;
    }
}