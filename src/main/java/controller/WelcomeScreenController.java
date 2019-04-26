package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {


    @FXML
    public AnchorPane mainPane;

    @FXML
    private Button registerSubstitute;

    @FXML
    private Button registerEmployer;

    public void initialize() {
        registerSubstitute.setOnAction(e -> {
            try {
                loadRegisterSubstitute();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        registerEmployer.setOnAction(e -> {
            try {
                loadRegisterEmployer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    private void loadRegisterEmployer() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/employer/register/RegisterEmployerView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Register employer");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loadRegisterSubstitute() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/substitute/register/RegisterSubstituteView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Register Substitute");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
