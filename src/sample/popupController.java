package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class popupController extends Application {

    @FXML
    Button back;
    @FXML
    Label bmivalue;



    @Override
    public void start(Stage primaryStage) throws IOException {
        File file = new File("out.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        st = br.readLine();
        System.out.println(st);
        bmivalue.setText("abc");
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void backtomain(ActionEvent actionEvent) {

    }
}

