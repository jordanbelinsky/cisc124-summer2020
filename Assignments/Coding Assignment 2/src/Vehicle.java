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
    public Vehicle(int regNum, CarOwner owner, double odometerReading, String make, String model, int year, int numWheels, String plateNumber) throws IllegalVehicle {
        this.registrationNumber = regNum;
        this.owner = owner;
        setOdometerReading(odometerReading);
        this.make = make;
        this.model = model;
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


    // Accessor methods for each instance variable
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public String getPlateNumber() {
        return plateNumber;
    }


    // Mutator methods for each instance variable
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setOwner(CarOwner owner) {
        this.owner = owner;
    }

    public void setOdometerReading(double odometerReading) throws IllegalVehicle {
        // Error handling to ensure new mileage entry is larger than the previous
        if (getOdometerReading() < odometerReading)
            this.odometerReading = odometerReading;
        else
            throw new IllegalVehicle("Illegal mileage - nice try!");
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) throws IllegalVehicle {
        // Error handling to ensure that the vehicle's year is the same or newer than 1980
        if (year >= 1980)
            this.year = year;
        else
            throw new IllegalVehicle("Illegal year - you need to buy a newer vehicle!");

    }

    public void setNumWheels(int numWheels) throws IllegalVehicle {
        // Error handling to ensure the vehicle has 2 or more wheels
        if (numWheels >= 2)
            this.numWheels = numWheels;
        else
            throw new IllegalVehicle("Illegal number of wheels - buy a unicycle!");

    }

    public void setPlateNumber(String plateNumber) throws IllegalVehicle {
        // Error handling to ensure the plate number matches the format of 4 letters and 3 digits
        if (plateNumber.toLowerCase().matches("^[a-z]{4}\\d{3}$"))
            this.plateNumber = plateNumber;
        else
            throw new IllegalVehicle("Illegal license plate!");
    }

    public static void main(String[] args) throws IllegalVehicle {
        CarOwner jordan = new CarOwner("Jordan", 18, "Male", "B-1105",1);
        Vehicle test = new Vehicle(1429511, jordan, 245978, "Honda", "CRV", 2019, 4, "ABEW056");
        System.out.println(test.toString());
    }
}
