public class Truck extends Vehicle {

    // Instance variables
    private boolean isSemi;
    private double loadCapacity;

    // Constructor for the class
    public Truck(int regNum, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber, boolean isSemi, double loadCapacity) throws IllegalVehicle {
        super(regNum, owner, odometerReading, make, model, year, numWheels, plateNumber);
        this.isSemi = isSemi;
        this.loadCapacity = loadCapacity;
    }

    // toString to allow for formatting while pulling the parent class instance variables
    @Override
    public String toString() {
        return "Truck { " +
                super.toString() +
                ", isSemi=" + isSemi +
                ", loadCapacity=" + loadCapacity +
                " }";
    }

    // getNumberAxles used to find the number of axles based upon number of wheels
    public int getNumberAxles(int numWheels) {
        return numWheels / 2;
    }


    // Accessor methods for each instance variable
    public boolean isSemi() {
        return isSemi;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }


    // Mutator methods for each instance variable
    public void setSemi(boolean semi) {
        isSemi = semi;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public static void main(String[] args) throws IllegalVehicle {
        CarOwner jordan = new CarOwner("Jordan", 18, "Male", "B-1105",1);
        Truck test = new Truck(1429511, jordan, 245978, "Honda", "CRV", 2019, 4, "ABEW056", false, 8264);
        System.out.println(test.toString());
    }
}
