/*
Name: Jordan Belinsky
File: Property.java
Purpose: The abstract parent class to be inherited by subclass property types.
*/

import java.util.ArrayList;

public abstract class Property {

    // Define instance variables
    private double listingPrice;

    // Initialize constructor for the class
    public Property(double listingPrice) throws BadProperty {
        setListingPrice(listingPrice);
    }

    /*
    Accessor methods
    */
    public double getListingPrice() {
        return listingPrice;
    }

    /*
    Mutator methods
    */
    public void setListingPrice(double listingPrice) throws BadProperty {
        if (listingPrice > 0)
            this.listingPrice = listingPrice;
        else
            throw new BadProperty("The listing price is less than or equal to 0.");
    }

    // compareTo method to find difference in price between two properties
    public double compareTo(Property propertyToCompare) {
        double difference;
        difference = this.getListingPrice() - propertyToCompare.getListingPrice();
        if (difference < 0)
            System.out.println("The " + propertyToCompare.getClass().getSimpleName() + " is more expensive than the " + this.getClass().getSimpleName() + ". The difference is $" + Math.abs(difference) + ".");
        else
            System.out.println("The " + this.getClass().getSimpleName() + " is more expensive than the " + propertyToCompare.getClass().getSimpleName() + ". The difference is $" + Math.abs(difference) + ".");
        return difference;

    }

    // Define abstract method to calculate tax - to be overridden in concrete subclasses
    public abstract double calculateTax();

}