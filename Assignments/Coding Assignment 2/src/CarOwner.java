/*
    Name: Jordan Belinsky
    File: CarOwner.java
    Purpose: Defines the CarOwner class which creates a CarOwner object to populate the Vehicle class and subclasses.
*/

public class CarOwner {

    // Instance variables
    private String name;
    private int age;
    private String gender;
    private String licenseNumber;
    private int yearsDriving;

    // Constructor for the class
    public CarOwner(String name, int age, String gender, String licenseNumber, int yearsDriving) throws IllegalVehicle {
        setName(name);
        setAge(age);
        setGender(gender);
        setLicenseNumber(licenseNumber);
        setYearsDriving(yearsDriving);
    }

    // toString to allow for formatting while pulling the instance variables
    @Override
    public String toString() {
        return "CarOwner { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", yearsDriving=" + yearsDriving +
                " }";
    }

    /*
    Accessor methods for each instance variable
    */
    public String getName() {
        // Fetches the owner's name
        return name;
    }

    public int getAge() {
        // Fetches the owner's age
        return age;
    }

    public String getGender() {
        // Fetches the owner's gender
        return gender;
    }

    public String getLicenseNumber() {
        // Fetches the owner's license number
        return licenseNumber;
    }

    public int getYearsDriving() {
        // Fetches the owner's years of driving experience
        return yearsDriving;
    }


    /*
    Mutator methods for each instance variable
    */
    public void setName(String name) {
        // Sets the owner's current name
        this.name = name;
    }

    public void setAge(int age) {
        // Sets the owner's current age
        this.age = age;
    }

    public void setGender(String gender) {
        // Sets the owner's current gender
        this.gender = gender;
    }

    public void setLicenseNumber(String licenseNumber) {
        // Sets the owner's current license number
        this.licenseNumber = licenseNumber;
    }

    public void setYearsDriving(int yearsDriving) throws IllegalVehicle {
        // Sets the owner's current years of driving experience
        // Error handling to ensure 0+ years of driving
        if (yearsDriving >= 0)
            this.yearsDriving = yearsDriving;
        else
            throw new IllegalVehicle("Illegal value!");
    }
}
