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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Bmi extends Application{

    @FXML
    TextField height;
    @FXML
    TextField weight;
    @FXML
    Button calculateBtn;


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/bmi.fxml"));
        primaryStage.setTitle("BMI Calculator");
        Scene primary = new Scene(root, 600, 400);
        primaryStage.setScene(primary);
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



    public void calculateBMI(ActionEvent actionEvent) throws IOException {
        float w = Float.parseFloat(weight.getText());
        float h = Float.parseFloat(height.getText());
        //AnchorPane pane = FXMLLoader.load(getClass().getResource("../resources/fxml/popup.fxml"));
        Float BMI = (float) (w/(h*h*0.01*0.01));
        Parent popup = FXMLLoader.load(getClass().getResource("../resources/fxml/popup.fxml"));

            new Thread(()-> {
                FileWriter fstream = null;
                try {
                    fstream = new FileWriter("out.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert fstream != null;
                BufferedWriter out = new BufferedWriter(fstream);
                try {
                    out.write(Float.toString(BMI));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Close the output stream
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


        Stage pop;
        pop = new Stage();

        pop.setScene(new Scene(popup, 600, 400));
        pop.show();

    }

    public void resetfields(ActionEvent actionEvent) {
        weight.setText("");
        height.setText("");
    }
}
