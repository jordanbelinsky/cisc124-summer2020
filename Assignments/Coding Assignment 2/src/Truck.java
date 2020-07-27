/*
    Name: Jordan Belinsky
    File: Truck.java
    Purpose: Defines the Truck class which is inherited from parent class Vehicle.
*/

public class Truck extends Vehicle {

    // Instance variables
    private boolean isSemi;
    private double loadCapacity;
    private int numberAxles;

    // Constructor for the class
    public Truck(int regNum, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber, boolean isSemi, double loadCapacity) throws IllegalVehicle {
        super(regNum, owner, odometerReading, make, model, year, numWheels, plateNumber);
        setSemi(isSemi);
        setLoadCapacity(loadCapacity);
        numberAxles = getNumberAxles(numWheels);
    }

    // toString to allow for formatting while pulling the parent class instance variables
    @Override
    public String toString() {
        return "Truck { " +
                super.toString() +
                ", isSemi=" + isSemi +
                ", loadCapacity=" + loadCapacity +
                ", numberAxles=" + numberAxles +
                " }";
    }

    // getNumberAxles used to find the number of axles based upon number of wheels
    public int getNumberAxles(int numWheels) {
        // Integer -> Integer
        return numWheels / 2;
    }


    /*
    Accessor methods for each instance variable
    */
    public boolean isSemi() {
        // Fetches state of Semi
        return isSemi;
    }

    public double getLoadCapacity() {
        // Fetches load capacity
        return loadCapacity;
    }


    /*
    Mutator methods for each instance variable
    */
    public void setSemi(boolean semi) {
        // Sets current state of Semi
        isSemi = semi;
    }

    public void setLoadCapacity(double loadCapacity) {
        // Sets current load capacity
        this.loadCapacity = loadCapacity;
    }
}
