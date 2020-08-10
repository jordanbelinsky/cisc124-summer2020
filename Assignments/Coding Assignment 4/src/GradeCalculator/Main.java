/*
Name: Jordan Belinsky
File: Main.java
Purpose: Define the main class from which the Grade Calculator is run and controlled.
*/

// Establish package name and import
package GradeCalculator;

// Import and intialize java and javafx classes
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    // start method used to create and display the JavaFX application scene
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load FXML file for GUI
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));

        // Set title  and sizing for the window
        primaryStage.setTitle("Weighted Average Calculator");
        primaryStage.setScene(new Scene(root, 700, 400));

        // Display and set minimum coordinates for the window
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }

    // Import JavaFX elements using FX:ID
    @FXML TextField a1Points;
    @FXML TextField a2Points;
    @FXML TextField a3Points;
    @FXML TextField a4Points;
    @FXML TextField a5Points;
    @FXML TextField a1Total;
    @FXML TextField a2Total;
    @FXML TextField a3Total;
    @FXML TextField a4Total;
    @FXML TextField a5Total;
    @FXML TextField a1Weight;
    @FXML TextField a2Weight;
    @FXML TextField a3Weight;
    @FXML TextField a4Weight;
    @FXML TextField a5Weight;
    @FXML Button calculateButton;
    @FXML Label averageLabel;

    // validate method used for error handling and alert display
    public boolean validate() {
        // Establish string for errors to be appended into
        StringBuilder errorList = new StringBuilder();
        boolean fullFields = true;

        // Convert TextFields to String format
        String a1P = a1Points.getText().trim();
        String a2P = a2Points.getText().trim();
        String a3P = a3Points.getText().trim();
        String a4P = a4Points.getText().trim();
        String a5P = a5Points.getText().trim();
        String a1T = a1Total.getText().trim();
        String a2T = a2Total.getText().trim();
        String a3T = a3Total.getText().trim();
        String a4T = a4Total.getText().trim();
        String a5T = a5Total.getText().trim();
        String a1W = a1Weight.getText().trim();
        String a2W = a2Weight.getText().trim();
        String a3W = a3Weight.getText().trim();
        String a4W = a4Weight.getText().trim();
        String a5W = a5Weight.getText().trim();

        // Check for empty entry fields and non-numeric entries
        if (a1P.isEmpty() || !(a1P.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter achieved points for Assignment 1 (number only)\n");
            fullFields = false;
        }
        if (a2P.isEmpty() || !(a2P.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter achieved points for Assignment 2 (number only)\n");
            fullFields = false;
        }
        if (a3P.isEmpty() || !(a3P.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter achieved points for Assignment 3 (number only)\n");
            fullFields = false;
        }
        if (a4P.isEmpty() || !(a4P.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter achieved points for Assignment 4 (number only)\n");
            fullFields = false;
        }
        if (a5P.isEmpty() || !(a5P.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter achieved points for Assignment 5 (number only)\n");
            fullFields = false;
        }
        if (a1T.isEmpty() || !(a1T.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter total available points for Assignment 1 (number only)\n");
            fullFields = false;
        }
        if (a2T.isEmpty() || !(a2T.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter total available points for Assignment 2 (number only)\n");
            fullFields = false;
        }
        if (a3T.isEmpty() || !(a3T.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter total available points for Assignment 3 (number only)\n");
            fullFields = false;
        }
        if (a4T.isEmpty() || !(a4T.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter total available points for Assignment 4 (number only)\n");
            fullFields = false;
        }
        if (a5T.isEmpty() || !(a5T.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter total available points for Assignment 5 (number only)\n");
            fullFields = false;
        }
        if (a1W.isEmpty() || !(a1W.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter the weighting for Assignment 1 (number only)\n");
            fullFields = false;
        }
        if (a2W.isEmpty() || !(a2W.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter the weighting for Assignment 2 (number only)\n");
            fullFields = false;
        }
        if (a3W.isEmpty() || !(a3W.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter the weighting for Assignment 3 (number only)\n");
            fullFields = false;
        }
        if (a4W.isEmpty() || !(a4W.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter the weighting for Assignment 4 (number only)\n");
            fullFields = false;
        }
        if (a5W.isEmpty() || !(a5W.matches("-?\\d+(\\.\\d+)?"))) {
            errorList.append("- Enter the weighting for Assignment 5 (number only)\n");
            fullFields = false;
        }
        else if (fullFields) {
            // Check that awarded points is less than or equal to the total available points
            if (Double.parseDouble(a1P) > Double.parseDouble(a1T)) {
                errorList.append("- Assignment 1: Awarded points are greater than total\n");
            }
            if (Double.parseDouble(a2P) > Double.parseDouble(a2T)) {
                errorList.append("- Assignment 2: Awarded points are greater than total\n");
            }
            if (Double.parseDouble(a3P) > Double.parseDouble(a3T)) {
                errorList.append("- Assignment 3: Awarded points are greater than total\n");
            }
            if (Double.parseDouble(a4P) > Double.parseDouble(a4T)) {
                errorList.append("- Assignment 4: Awarded points are greater than total\n");
            }
            if (Double.parseDouble(a5P) > Double.parseDouble(a5T)) {
                errorList.append("- Assignment 5: Awarded points are greater than total\n");
            }

            // Check that sum of weighting does not exceed 100
            Double a1 = Double.parseDouble(a1W);
            Double a2 = Double.parseDouble(a2W);
            Double a3 = Double.parseDouble(a3W);
            Double a4 = Double.parseDouble(a4W);
            Double a5 = Double.parseDouble(a5W);
            Double sum = (a1 + a2 + a3 + a4 + a5);
            if (sum > 100) {
                errorList.append("- Total weighting cannot exceed 100%");
            }

        }

        // If errors are present create an Alert and halt the program
        if (errorList.length() > 0) {
            // Establish alert object
            Alert errorMessage = new Alert(Alert.AlertType.WARNING);

            // Set title and text attributes to be displayed in the alert error
            errorMessage.setTitle("Input Error Encountered");
            errorMessage.setHeaderText("Please Populate Required Fields");
            errorMessage.setContentText(errorList.toString());

            // Configure alert error to display and halt the program until addressed by user
            errorMessage.showAndWait();

            // If errors are found, program has been halted
            return false;
        } else {
            // If no errors are found, program has been validated and can continue running
            return true;
        }
    }

    // calcNumerator method for calculating the numerator of the average calculation, returns a double value
    public double calcNumerator(TextField points, TextField total, TextField weight) {
        // Get the string value for each text field
        String pointString = points.getText();
        String totalString = total.getText();
        String weightString = weight.getText();

        // Get the double value from the string value
        double pointValue = Double.parseDouble(pointString);
        double totalValue = Double.parseDouble(totalString);
        double weightValue = Double.parseDouble(weightString);

        // Return the final value for the numerator
        return ((pointValue/totalValue)*weightValue)*100;
    }

    // calcDenominator method for calculating the denominator of the average calculation, returns a double value
    public double calcDenominator(TextField weight) {
        // Get the string value for each text field
        String weightString = weight.getText();

        // Get the double value from the string value
        double weightValue = Double.parseDouble(weightString);

        // Return the final value for the denominator
        return weightValue;
    }

    // calcAverage method for combining the numerator and denominator for a final calculation, rewturns a double[]
    public double[] calcAverage() {
        // Calculate the numerator values for each assignment
        double num1 = calcNumerator(a1Points, a1Total, a1Weight);
        double num2 = calcNumerator(a2Points, a2Total, a2Weight);
        double num3 = calcNumerator(a3Points, a3Total, a3Weight);
        double num4 = calcNumerator(a4Points, a4Total, a4Weight);
        double num5 = calcNumerator(a5Points, a5Total, a5Weight);

        // Calculate the denominator values for each assignment
        double den1 = calcDenominator(a1Weight);
        double den2 = calcDenominator(a2Weight);
        double den3 = calcDenominator(a3Weight);
        double den4 = calcDenominator(a4Weight);
        double den5 = calcDenominator(a5Weight);

        // Calculate the numerator and denominator sum for the average calculation
        double numerator = num1 + num2 + num3 + num4 + num5;
        double denominator = den1 + den2 + den3 + den4 + den5;

        // Calculate the average
        double average = numerator/denominator;
        double[] details = new double[2];
        details[0] = average;
        details[1] = denominator;

        // Return the average as a double value
        return details;
    }

    // calculateGradeTier method for calculating the marks required for the user for each tier of the Queen's GPA scale
    public void calculateGradeTier(double grade, double weight) {
        // Calculate percentage required for each GPA scale tier
        double aPlus = (90*100 - grade*weight)/(100-weight);
        double a = (85*100 - grade*weight)/(100-weight);
        double aMinus = (80*100 - grade*weight)/(100-weight);
        double bPlus = (77*100 - grade*weight)/(100-weight);
        double b = (73*100 - grade*weight)/(100-weight);
        double bMinus = (70*100 - grade*weight)/(100-weight);
        double cPlus = (67*100 - grade*weight)/(100-weight);
        double c = (63*100 - grade*weight)/(100-weight);
        double cMinus = (60*100 - grade*weight)/(100-weight);
        double dPlus = (57*100 - grade*weight)/(100-weight);
        double d = (53*100 - grade*weight)/(100-weight);
        double dMinus = (50*100 - grade*weight)/(100-weight);
        double f = (0*100 - grade*weight)/(100-weight);

        // Printing output for required grades
        System.out.println("You need to obtain " + Math.round(aPlus*100.0)/100.0 + "% on the remaining assignments to have an A+ average in the course.");
        System.out.println("You need to obtain " + Math.round(a*100.0)/100.0 + "% on the remaining assignments to have an A average in the course.");
        System.out.println("You need to obtain " + Math.round(aMinus*100.0)/100.0 + "% on the remaining assignments to have an A- average in the course.");
        System.out.println("You need to obtain " + Math.round(bPlus*100.0)/100.0 + "% on the remaining assignments to have an B+ average in the course.");
        System.out.println("You need to obtain " + Math.round(b*100.0)/100.0 + "% on the remaining assignments to have an B average in the course.");
        System.out.println("You need to obtain " + Math.round(bMinus*100.0)/100.0 + "% on the remaining assignments to have an B- average in the course.");
        System.out.println("You need to obtain " + Math.round(cPlus*100.0)/100.0 + "% on the remaining assignments to have an C+ average in the course.");
        System.out.println("You need to obtain " + Math.round(c*100.0)/100.0 + "% on the remaining assignments to have an C average in the course.");
        System.out.println("You need to obtain " + Math.round(cMinus*100.0)/100.0 + "% on the remaining assignments to have an C- average in the course.");
        System.out.println("You need to obtain " + Math.round(dPlus*100.0)/100.0 + "% on the remaining assignments to have an D+ average in the course.");
        System.out.println("You need to obtain " + Math.round(d*100.0)/100.0 + "% on the remaining assignments to have an D average in the course.");
        System.out.println("You need to obtain " + Math.round(dMinus*100.0)/100.0 + "% on the remaining assignments to have an D- average in the course.");
        System.out.println("You need to obtain " + Math.round(f*100.0)/100.0 + "% on the remaining assignments to have an F average in the course.");
    }

    // outputGradeDetails method for displaying all output data into the console and GUI window
    public void outputGradeDetails() {
        // Pull data from calculate average method
        double[] averageDetails = calcAverage();
        double currentAverage = averageDetails[0];
        double currentWeight = averageDetails[1];

        // Display current average in GUI via average label
        averageLabel.setText("Your current average in the course is: " + Math.round(currentAverage*100.0)/100.0 + "%");

        // Print current grade details to the console
        System.out.println("Your current grades account for " + currentWeight + "% of your final average.");
        System.out.println("Your current average is " + Math.round(currentAverage*100.0)/100.0);

        // Print and calculate required marks for each grade tier
        calculateGradeTier(currentAverage, currentWeight);
    }

    // initialize method for addressing the action and event handling of the calculate button
    public void initialize() {
        calculateButton.setOnAction((event) -> {
            // Run through validate to ensure that all error handling is verified before continuing
            if (validate()) {
                // Calculate the average
                outputGradeDetails();

            }
        });
    }

    // main()
    public static void main(String[] args) {
        // Launch the application
        launch(args);
    }
}
