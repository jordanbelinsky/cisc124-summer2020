/*
    Name: Jordan Belinsky
    File: Motorcycle.java
    Purpose: Defines the Motorcycle class which is inherited from parent class Vehicle.
*/

public class Motorcycle extends Vehicle {

    // Constructor for the class
    public Motorcycle(int regNum, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber) throws IllegalVehicle {
        super(regNum, owner, odometerReading, make, model, year, numWheels, plateNumber);
    }

    // toString to allow for formatting while pulling the parent class instance variables
    @Override
    public String toString() {
        return "Motorcycle { " +
                super.toString() +
                " }";
    }
}
