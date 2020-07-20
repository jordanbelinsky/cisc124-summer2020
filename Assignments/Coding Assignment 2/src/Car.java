public class Car extends Vehicle {

    // Instance variables
    private int numSeats;
    private boolean isSUV;

    // Constructor for the class
    public Car(int regNum, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber, int numSeats, boolean isSUV) throws IllegalVehicle {
        super(regNum, owner, odometerReading, make, model, year, numWheels, plateNumber);
        this.numSeats = numSeats;
        this.isSUV = isSUV;
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

    // Accessor methods for each instance variable
    public int getNumSeats() {
        return numSeats;
    }

    public boolean isSUV() {
        return isSUV;
    }


    // Mutator methods for each instance variable
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public void setSUV(boolean SUV) {
        isSUV = SUV;
    }

    // main() used for testing
    public static void main(String[] args) throws IllegalVehicle {
        CarOwner jordan = new CarOwner("Jordan", 18, "Male", "B-1105",1);
        Car test = new Car(1429511, jordan, 245978, "Honda", "CRV", 2019, 4, "ABEW056", 8, true);
        System.out.println(test.toString());
    }
}