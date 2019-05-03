package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.filemanager.savetofile.CSVWriter;

import java.io.IOException;

public class MainController {

    @FXML
    public AnchorPane mainPane;

    @FXML
    private Button registerSubstitute;

    @FXML
    private Button registerEmployer;

    @FXML
    private Button registerSubstitutePosition;

    @FXML
    private Button availableSubstitutes;

    @FXML
    private Button substitutePositions;

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

        registerSubstitutePosition.setOnAction(e -> {
            try {
                loadRegisterSubstitutePosition();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        availableSubstitutes.setOnAction(e -> {
            try {
                loadAvailableSubstitutes();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        substitutePositions.setOnAction(e -> {
            try {
                loadSubstitutePositions();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    private void loadRegisterEmployer() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/register/employer/RegisterEmployerView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Register employer");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loadRegisterSubstitute() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/register/substitute/RegisterSubstituteView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Register Substitute");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loadRegisterSubstitutePosition() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/register/substituteposition/RegisterSubstitutePositionView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Register Substitute position");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loadAvailableSubstitutes() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/register/substitute/SubstituteTableView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Available substitutes");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loadSubstitutePositions() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/register/substituteposition/SubstitutePositionsView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Available substitute positions");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
