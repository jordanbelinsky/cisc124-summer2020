/*
    Name: Jordan Belinsky
    File: Vehicle.java
    Purpose: Defines the Vehicle class which acts as the parent class for Car, Truck and Motorcycle.
*/

public class Vehicle {

    // Instance variables
    private int registrationNumber;
    private CarOwner owner;
    private double odometerReading;
    private String make;
    private String model;
    private int year;
    private int numWheels;
    private String plateNumber;


    // Constructor for the class
    public Vehicle(int registrationNumber, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber) throws IllegalVehicle {
        setRegistrationNumber(registrationNumber);
        setOwner(owner);
        setOdometerReading(odometerReading);
        setMake(make);
        setModel(model);
        setYear(year);
        setNumWheels(numWheels);
        setPlateNumber(plateNumber);
    }


    // toString method for the parent class
    @Override
    public String toString() {
        return "registrationNumber=" + registrationNumber +
                ", owner=" + owner.getName() +
                ", odometerReading=" + odometerReading +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", numWheels=" + numWheels +
                ", plateNumber='" + plateNumber + '\'';
    }


    /*
    Accessor methods for each instance variable
    */
    public int getRegistrationNumber() {
        // Fetches the vehicle's registration number
        return registrationNumber;
    }

    public CarOwner getOwner() {
        // Fetches the vehicle's owner
        return owner;
    }

    public double getOdometerReading() {
        // Fetches the vehicle's odometer reading
        return odometerReading;
    }

    public String getMake() {
        // Fetches the vehicle's make
        return make;
    }

    public String getModel() {
        // Fetches the vehicle's model
        return model;
    }

    public int getYear() {
        // Fetches the vehicle's year
        return year;
    }

    public int getNumWheels() {
        // Fetches the vehicle's number of wheels
        return numWheels;
    }

    public String getPlateNumber() {
        // Fetches the vehicle's plate number
        return plateNumber;
    }


    /*
    Mutator methods for each instance variable
    */
    public void setRegistrationNumber(int registrationNumber) {
        // Sets the vehicle's current registration number
        this.registrationNumber = registrationNumber;
    }

    public void setOwner(CarOwner owner) {
        // Sets the vehicle's current owner
        this.owner = owner;
    }

    public void setOdometerReading(double odometerReading) throws IllegalVehicle {
        // Sets the vehicle's current odometer reading
        // Error handling to ensure new mileage entry is larger than the previous
        if (getOdometerReading() < odometerReading)
            this.odometerReading = odometerReading;
        else
            throw new IllegalVehicle("Illegal mileage - nice try!");
    }

    public void setMake(String make) {
        // Sets the vehicle's current make
        this.make = make;
    }

    public void setModel(String model) {
        // Sets the vehicle's current model
        this.model = model;
    }

    public void setYear(int year) throws IllegalVehicle {
        // Sets the vehicle's current year
        // Error handling to ensure that the vehicle's year is the same or newer than 1980
        if (year >= 1980)
            this.year = year;
        else
            throw new IllegalVehicle("Illegal year - you need to buy a newer vehicle!");

    }

    public void setNumWheels(int numWheels) throws IllegalVehicle {
        // Sets the vehicle's current number of wheels
        // Error handling to ensure the vehicle has 2 or more wheels
        if (numWheels >= 2)
            this.numWheels = numWheels;
        else
            throw new IllegalVehicle("Illegal number of wheels - buy a unicycle!");

    }

    public void setPlateNumber(String plateNumber) throws IllegalVehicle {
        // Sets the vehicle's current plate number
        // Error handling to ensure the plate number matches the format of 4 letters and 3 digits
        if (plateNumber.toLowerCase().matches("^[a-z]{4}\\d{3}$"))
            this.plateNumber = plateNumber;
        else
            throw new IllegalVehicle("Illegal license plate!");
    }
}
