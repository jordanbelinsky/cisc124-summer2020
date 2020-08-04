/*
Name: Jordan Belinsky
File: Cottage.java
Purpose: Define Cottage, a subclass of House.
*/

public class Cottage extends House {

    // Define instance variables
    private double lakeFrontage;

    // Initialize constructor for the class
    public Cottage(double listingPrice, double floorSpace, int bedroomNumber, int bathroomNumber, double lotWidth, double lotDepth, double lakeFrontage) throws BadProperty {
        super(listingPrice, floorSpace, bedroomNumber, bathroomNumber, lotWidth, lotDepth, HouseType.WATERFRONT_HOME);
        setLakeFrontage(lakeFrontage);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        return "Cottage, " +
                HouseType.WATERFRONT_HOME + " purpose, " +
                super.getLotWidth() + " m width by " +
                super.getLotDepth() + " m deep lot, " +
                super.getBedroomNumber() + " bedrooms, " +
                super.getBathroomNumber() + " bathrooms, " +
                super.getFloorSpace() + " square meter building, " +
                lakeFrontage + " m of lake frontage, asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public double getLakeFrontage() {
        return lakeFrontage;
    }

    /*
    Mutator methods
    */
    public void setLakeFrontage(double lakeFrontage) throws BadProperty {
        if (lakeFrontage > 0)
            this.lakeFrontage = lakeFrontage;
        else
            throw new BadProperty("The lake frontage value is less than or equal to 0.");
    }

    // Override calculateTax abstract method with correct tax calculation
    @Override
    public double calculateTax() {
        double tax = 2000 + (2*lakeFrontage);
        return tax;
    }
}
