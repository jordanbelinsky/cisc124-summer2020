/*
Name: Jordan Belinsky
File: Land.java
Purpose: Define Land, a subclass of Property.
*/

public class Land extends Property {

    // Define instance variables
    private double hectaresNumber;

    // Initialize constructor for the class
    public Land(double listingPrice, double hectaresNumber) throws BadProperty {
        super(listingPrice);
        setHectaresNumber(hectaresNumber);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        return "Land, " +
                hectaresNumber + " hectares in size, asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public double getHectaresNumber() {
        return hectaresNumber;
    }

    /*
    Mutator methods
    */
    public void setHectaresNumber(double hectaresNumber) throws BadProperty {
        if (hectaresNumber > 0)
            this.hectaresNumber = hectaresNumber;
        else
            throw new BadProperty("The number of hectares is less than or equal to 0.");
    }

    // Override calculateTax abstract method with correct tax calculation
    @Override
    public double calculateTax() {
        double tax = (100*hectaresNumber);
        return tax;
    }
}
