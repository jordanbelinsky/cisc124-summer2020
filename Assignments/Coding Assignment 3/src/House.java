/*
Name: Jordan Belinsky
File: House.java
Purpose: Define House, a subclass of Property.
*/

// Define HouseType enum
enum HouseType {
    TOWNHOUSE,
    DETACHED,
    DUPLEX,
    WATERFRONT_HOME
}

public class House extends Property {

    // Define instance variables
    private int bathroomNumber;
    private int bedroomNumber;
    private double lotDepth;
    private double lotWidth;
    private double floorSpace;
    private HouseType classification;

    // Initialize constructor for the class
    public House(double listingPrice, double floorSpace, int bedroomNumber, int bathroomNumber, double lotWidth, double lotDepth, HouseType classification) throws BadProperty {
        super(listingPrice);
        setFloorSpace(floorSpace);
        setBedroomNumber(bedroomNumber);
        setBathroomNumber(bathroomNumber);
        setLotWidth(lotWidth);
        setLotDepth(lotDepth);
        setClassification(classification);
    }

    // toString to control formatting of output message printing instance variables
    @Override
    public String toString() {
        return "House, " +
                lotWidth + " m width by " +
                lotDepth + " m deep lot, " +
                bedroomNumber + " bedrooms, " +
                floorSpace + " square meter building, asking price $" +
                super.getListingPrice() + ".";
    }

    /*
    Accessor methods
    */
    public int getBathroomNumber() {
        return bathroomNumber;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }

    public double getLotDepth() {
        return lotDepth;
    }

    public double getLotWidth() {
        return lotWidth;
    }

    public double getFloorSpace() {
        return floorSpace;
    }

    public HouseType getClassification() {
        return classification;
    }

    /*
    Mutator methods
    */
    public void setBathroomNumber(int bathroomNumber) throws BadProperty {
        if (bathroomNumber > 0)
            this.bathroomNumber = bathroomNumber;
        else
            throw new BadProperty("Invalid number of bathrooms.");
    }

    public void setBedroomNumber(int bedroomNumber) throws BadProperty {
        if (bedroomNumber > 0)
            this.bedroomNumber = bedroomNumber;
        else
            throw new BadProperty("Invalid number of bedrooms.");
    }

    public void setLotDepth(double lotDepth) {
        this.lotDepth = lotDepth;
    }

    public void setLotWidth(double lotWidth) {
        this.lotWidth = lotWidth;
    }

    public void setFloorSpace(double floorSpace) {
        this.floorSpace = floorSpace;
    }

    public void setClassification(HouseType classification) {
        this.classification = classification;
    }

    // Override calculateTax abstract method with correct tax calculation
    @Override
    public double calculateTax() {
        double tax = 1000 + (50*bedroomNumber) + (10*floorSpace);
        return tax;
    }
}
