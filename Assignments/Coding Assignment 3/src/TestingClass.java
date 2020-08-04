/*
Name: Jordan Belinsky
File: TestingClass.java
Purpose: A class to test invoking each function of the overall program to ensure working order.
*/

import java.util.ArrayList;

public class TestingClass {
    public static void main(String[] args) throws BadProperty {

        // Define property database ArrayList
        ArrayList<Property> propertyDatabase = new ArrayList<Property>();

        // Define and add legal properties
        Property property1 = new Office(120, 3, 1500, true, OfficeType.SERVICE);
        Property property2 = new Farm(250, 3400, "vegetables");
        Property property3 = new ApartmentBuilding(70, 5, 2, 40, 80);
        propertyDatabase.add(property1);
        propertyDatabase.add(property2);
        propertyDatabase.add(property3);

        // Define and add illegal properties (REMOVE TO CONTINUE TESTING!)
        Property property4 = new House(140, 4, 0, 4, 40, 50, HouseType.DUPLEX);
        propertyDatabase.add(property4);

        // Test accessors and mutators
        System.out.println(((Office)property1).getClassification());
        System.out.println();
        System.out.println(((Farm)property2).getCrop());
        System.out.println();
        System.out.println(((ApartmentBuilding)property3).getTenantNumber());
        System.out.println();

        // Compare legal properties
        property1.compareTo(property2);
        System.out.println();
        property2.compareTo(property3);
        System.out.println();
        property1.compareTo(property3);
        System.out.println();

        // Loop through property database to invoke toString and calculateTax methods for each property entry
        for (Property property : propertyDatabase) {
            System.out.println(property.toString());
            System.out.println("Calculated tax: " + property.calculateTax());
            System.out.println();
        }
    }
}
