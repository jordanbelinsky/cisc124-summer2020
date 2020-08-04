/*
Name: Jordan Belinsky
File: MultiUnitBuilding.java
Purpose: Define MultiUnitBuilding, a subclass of Property.
*/

public abstract class MultiUnitBuilding extends Property {

    // Define instance variables
    private int unitNumber;
    private boolean hasElevator;
    private double floorSpace;

    // Initialize constructor for the class
    public MultiUnitBuilding(double listingPrice, double floorSpace, int unitNumber, boolean hasElevator) throws BadProperty {
        super(listingPrice);
        setFloorSpace(floorSpace);
        setUnitNumber(unitNumber);
        setHasElevator(hasElevator);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        String elevatorResult;
        if (hasElevator == true)
            elevatorResult = "has an elevator";
        else {
            elevatorResult = "no elevator";
        }

        return "Multi Unit Building, " +
                unitNumber + " units, " +
                floorSpace + " square meter building, " +
                elevatorResult + ", asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public int getUnitNumber() {
        return unitNumber;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }

    public double getFloorSpace() {
        return floorSpace;
    }

    /*
    Mutator methods
    */
    public void setUnitNumber(int unitNumber) throws BadProperty {
        if (unitNumber > 0)
            this.unitNumber = unitNumber;
        else
            throw new BadProperty("The number of units is less than or equal to 0.");
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    public void setFloorSpace(double floorSpace) throws BadProperty {
        if (floorSpace > 0)
            this.floorSpace = floorSpace;
        else
            throw new BadProperty("The floor space is less than or equal to 0 square meters.");
    }
}
