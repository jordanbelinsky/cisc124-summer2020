package GradeCalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
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

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Weighted Average Calculator");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }

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

    public void numberOfAssignments(boolean a1Bool, boolean a2Bool, boolean a3Bool, boolean a4Bool, boolean a5Bool) {
        if (a1Points.getText().trim().isEmpty())
            a1Bool = false;
        if (a2Points.getText().trim().isEmpty())
            a2Bool = false;
        if (a3Points.getText().trim().isEmpty())
            a3Bool = false;
        if (a4Points.getText().trim().isEmpty())
            a4Bool = false;
        if (a5Points.getText().trim().isEmpty())
            a5Bool = false;
    }

    @FXML protected void handleCalculate(ActionEvent actionEvent) {
        boolean a1State = true;
        boolean a2State = true;
        boolean a3State = true;
        boolean a4State = true;
        boolean a5State = true;
        numberOfAssignments(a1State, a2State, a3State, a4State, a5State);
        System.out.println(a1State);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
