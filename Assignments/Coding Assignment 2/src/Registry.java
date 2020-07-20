import java.util.ArrayList;

public class Registry {

    // Instance variables
    private ArrayList<Vehicle> vehicleCollection;
    private int numVehicles;

    // addVehicle used to add new Vehicle objects to the collection ArrayList
    public void addVehicle(Vehicle vehicle) {
        vehicleCollection.add(vehicle);
    }

    // printRegistry used to loop through the collection ArrayList and use toString to print each Vehicle instance
    public void printRegistry(ArrayList<Vehicle> vehicleCollection) {
        for (Vehicle vehicle : vehicleCollection) {
            System.out.println(vehicle.toString());
        }
    }

    // averageMileage used to loop through the collection ArrayList and calculate the average mileage of all the vehicles
    public double averageMileage(ArrayList<Vehicle> vehicleCollection) {
        double mileageSum = 0;
        int mileageCount = 0;

        for (Vehicle vehicle : vehicleCollection) {
            mileageSum += vehicle.getOdometerReading();
            mileageCount += 1;
        }

        double avgMileage = mileageSum / mileageCount;

        return avgMileage;
    }

    // Accessor methods for each instance variable
    public ArrayList<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public int getNumVehicles() {
        return numVehicles;
    }


    // Mutator methods for each instance variable
    public void setVehicleCollection(ArrayList<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }

    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
    }
}
