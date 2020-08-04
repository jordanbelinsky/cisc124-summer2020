/*
Name: Jordan Belinsky
File: Farm.java
Purpose: Define Farm, a subclass of Land.
*/

public class Farm extends Land {

    // Define instance variables
    private String crop;

    // Initialize constructor for the class
    public Farm(double listingPrice, double hectaresNumber, String crop) throws BadProperty {
        super(listingPrice, hectaresNumber);
        setCrop(crop);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        return "Farm, " +
                crop + " crop, " +
                super.getHectaresNumber() + " hectares in size, asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public String getCrop() {
        return crop;
    }

    /*
    Mutator methods
    */
    public void setCrop(String crop) throws BadProperty {
        if ((crop == ("")) | (crop == null))
            throw new BadProperty("Invalid crop type entered");
        else if (!(crop instanceof String))
            throw new BadProperty("Crop type is not a string.");
        else
            this.crop = crop;
    }

    // Override calculateTax abstract method with correct tax calculation
    @Override
    public double calculateTax() {
        double tax = (50*super.getHectaresNumber());
        return tax;
    }
}
