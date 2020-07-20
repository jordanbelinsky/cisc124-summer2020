public class CarOwner {

    // Instance variables
    private String name;
    private int age;
    private String gender;
    private String licenseNumber;
    private int yearsDriving;

    // Constructor for the class
    public CarOwner(String name, int age, String gender, String licenseNumber, int yearsDriving) throws IllegalVehicle {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.licenseNumber = licenseNumber;
        setYearsDriving(yearsDriving);
    }

    // Accessor methods for each instance variable
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getYearsDriving() {
        return yearsDriving;
    }


    // Mutator methods for each instance variable
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setYearsDriving(int yearsDriving) throws IllegalVehicle {
        // Error handling to ensure 0+ years of driving
        if (age >= 0)
            this.yearsDriving = yearsDriving;
        else
            throw new IllegalVehicle("Illegal value!");
    }
}
