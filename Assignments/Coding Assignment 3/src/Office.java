/*
Name: Jordan Belinsky
File: Office.java
Purpose: Define Office, a subclass of MultiUnitBuilding.
*/

// Define OfficeType enum
enum OfficeType {
    SERVICE,
    SALES,
    INDUSTRIAL
}

public class Office extends MultiUnitBuilding {

    // Define instance variables
    private OfficeType classification;

    // Initialize constructor for the class
    public Office(double listingPrice, double floorSpace, int unitNumber, boolean hasElevator, OfficeType classification) throws BadProperty {
        super(listingPrice, floorSpace, unitNumber, hasElevator);
        setClassification(classification);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        String elevatorResult;
        if (super.isHasElevator() == true)
            elevatorResult = "has an elevator";
        else
            elevatorResult = "no elevator";


        return "Office, " +
                classification + " purpose, " +
                super.getUnitNumber() + " units, " +
                super.getFloorSpace() + " square meter building, " +
                elevatorResult + ", asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public OfficeType getClassification() {
        return classification;
    }

    /*
    Mutator methods
    */
    public void setClassification(OfficeType classification) {
        this.classification = classification;
    }

    // Override calculateTax abstract method with correct tax calculation
    @Override
    public double calculateTax() {
        double elevatorFee;
        double discount;

        if (super.isHasElevator() == true)
            elevatorFee = 50;
        else
            elevatorFee = 0;

        if (classification == OfficeType.INDUSTRIAL)
            discount = 1 - 0.15;
        else if (classification == OfficeType.SERVICE)
            discount = 1 - 0.05;
        else
            discount = 1;

        double tax = ((10*super.getFloorSpace()) + (20*super.getUnitNumber()) + elevatorFee)*discount;
        return tax;
    }
}
