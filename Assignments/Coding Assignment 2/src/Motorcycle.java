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

    // main() used for testing
    public static void main(String[] args) throws IllegalVehicle {
        CarOwner jordan = new CarOwner("Jordan", 18, "Male", "B-1105",1);
        Motorcycle test = new Motorcycle(1429511, jordan, 245978, "Honda", "CRV", 2019, 4, "ABEW056");
        System.out.println(test.toString());
    }
}
