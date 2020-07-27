/*
    Name: Jordan Belinsky
    File: Registry.java
    Purpose: Defines the Registry class which keeps track of and displays the collection of all Vehicle types.
*/

import java.util.ArrayList;

public class Registry {

    // Instance variables
    private static ArrayList<Vehicle> vehicleCollection = new ArrayList<Vehicle>();
    private int numVehicles;

    // Constructor for the class
    public Registry(ArrayList<Vehicle> vehicleCollection, int numVehicles) {
        setVehicleCollection(vehicleCollection);
        setNumVehicles(numVehicles);
    }

    // toString to allow for formatting while pulling the instance variables
    @Override
    public String toString() {
        return "Registry { " +
                "vehicleCollection=" + vehicleCollection +
                ", numVehicles=" + numVehicles +
                " }";
    }

    // addVehicle used to add new Vehicle objects to the collection ArrayList
    public static void addVehicle(Vehicle vehicle) {
        vehicleCollection.add(vehicle);
    }

    // printRegistry used to loop through the collection ArrayList and use toString to print each Vehicle instance
    public static void printRegistry(ArrayList<Vehicle> vehicleCollection) {
        for (Vehicle vehicle : vehicleCollection) {
            System.out.println(vehicle.toString());
        }
    }

    // averageMileage used to loop through the collection ArrayList and calculate the average mileage of all the vehicles
    public double averageMileage(ArrayList<Vehicle> vehicleCollection) {
        // ArrayList<Vehicle> -> double
        double mileageSum = 0;
        int mileageCount = 0;

        for (Vehicle vehicle : vehicleCollection) {
            mileageSum += vehicle.getOdometerReading();
            mileageCount += 1;
        }

        double avgMileage = mileageSum / mileageCount;

        return avgMileage;
    }

    /*
    Accessor methods for each instance variable
    */
    public ArrayList<Vehicle> getVehicleCollection() {
        // Fetches the collection of vehicles
        return vehicleCollection;
    }

    public int getNumVehicles() {
        // Fetches the number of vehicles
        return numVehicles;
    }


    /*
    Mutator methods for each instance variable
    */
    public void setVehicleCollection(ArrayList<Vehicle> vehicleCollection) {
        // Sets the current vehicle collection
        this.vehicleCollection = vehicleCollection;
    }

    public void setNumVehicles(int numVehicles) {
        // Sets the current number of vehicles
        this.numVehicles = numVehicles;
    }

    // main for registry testing
    public static void main(String[] args) throws IllegalVehicle {
        // Initialize example vehicles
        CarOwner Jordan = new CarOwner("Jordan", 18, "Male", "B-1105",1);
        Vehicle vehicle = new Vehicle(1429511, Jordan, 245978, "Honda", "CRV", 2019, 4, "AHDW088");
        Car car = new Car(1516843, Jordan, 21485, "Honda", "Pilot", 2019, 4, "ABUS073", 8, true);
        Truck truck = new Truck(2495175, Jordan, 5243157, "Tesla", "Cybertruck", 2021, 6, "ELON111", false, 8264);
        Motorcycle motorcycle = new Motorcycle(5149357, Jordan, 5181, "Yamaha", "MT-10", 2020, 2, "BDHA295");

        // Add example vehicles to the collection
        addVehicle(vehicle);
        addVehicle(car);
        addVehicle(truck);
        addVehicle(motorcycle);

        // Test printing of vehicle collection
        printRegistry(vehicleCollection);
    }
}
