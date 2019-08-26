package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class Bmi extends Application{
    @FXML
    TextField height;
    @FXML
    TextField weight;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/bmi.fxml"));
        primaryStage.setTitle("BMI Calculator");
        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();
    }



        //Scene scene1 = new Scene(layout1, 300, 250);

        //button2.setOnAction(e -> primaryStage.setScene(scene1));

        //Scene scene2 = new Scene(layout2, 300, 250);
        //button1.setOnAction(e -> primaryStage.setScene(scene2));

        //primaryStage.setScene(scene1);
        //primaryStage.show();



        public static void main(String[] args) {
            launch(args);
        }

    @FXML
    public void calculateBMI(ActionEvent actionEvent) throws IOException {
        Float w = Float.parseFloat(weight.getText());
        Float h = Float.parseFloat(height.getText());
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("../resources/fxml/popup.fxml"));
        float BMI = (float) (w/(h*h*0.01*0.01));

        System.out.println(BMI);

    }

    public void resetfields(ActionEvent actionEvent) {
        weight.setText("");
        height.setText("");
    }
}
