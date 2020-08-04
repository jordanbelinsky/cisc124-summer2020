/*
Name: Jordan Belinsky
File: ApartmentBuilding.java
Purpose: Define ApartmentBuilding, a subclass of MultiUnitBuilding.
*/

public class ApartmentBuilding extends MultiUnitBuilding {

    // Define instance variables
    private int tenantNumber;
    private double unitFloorSpace;

    // Initialize constructor for the class
    public ApartmentBuilding(double listingPrice, double floorSpace, double unitFloorSpace, int unitNumber, int tenantNumber) throws BadProperty {
        super(listingPrice, floorSpace, unitNumber, true);
        setUnitFloorSpace(unitFloorSpace);
        setTenantNumber(tenantNumber);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        String elevatorResult;
        if (super.isHasElevator() == true)
            elevatorResult = "has an elevator";
        else
            elevatorResult = "no elevator";


        return "Apartment Building, " +
                super.getUnitNumber() + " units, " +
                super.getFloorSpace() + " square meter building, " +
                elevatorResult + ", " +
                tenantNumber + " tenant(s), asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public int getTenantNumber() {
        return tenantNumber;
    }

    public double getUnitFloorSpace() {
        return unitFloorSpace;
    }

    /*
    Mutator methods
    */
    public void setTenantNumber(int tenantNumber) {
        this.tenantNumber = tenantNumber;
    }

    public void setUnitFloorSpace(double unitFloorSpace) throws BadProperty {
        if (unitFloorSpace > 0)
            this.unitFloorSpace = unitFloorSpace;
        else
            throw new BadProperty("The floor space is less than or equal to 0 square meters.");
    }

    // Override calculateTax abstract method with correct tax calculation
    @Override
    public double calculateTax() {
        double tax = (35*unitFloorSpace);
        return tax;
    }
}
