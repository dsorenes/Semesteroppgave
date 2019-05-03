package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class MainViewController {


    @FXML
    private BorderPane ChangeableView;

    @FXML
    private void RegisterSubstitute(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substitute/contact/RegisterContactInformationView.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void RegisterEmployer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/employer/RegisterEmployerView.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void RegisterSubstitutePosition(ActionEvent event) {
        try {

            Stage stage = new Stage();

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/register/substituteposition/RegisterSubstitutePositionView.fxml"))));
            stage.show();

        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void AvailableSubstitutes(ActionEvent event) {
        try {

            Stage stage = new Stage();

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/tableview/SubstituteTableView.fxml"))));
            stage.show();

        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void AvailableSubstitutePositions(ActionEvent event) {
        try {

            Stage stage = new Stage();

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/register/substituteposition/SubstitutePositionsView.fxml"))));
            stage.show();

        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void AssignPosition(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/assignposition/AssignPosition.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void AssignedPositions(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tableview/AssignedPositions.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }



    @FXML
    public void FileBtn(ActionEvent event) {

        try {

            Stage stage = new Stage();

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/FileManager.fxml"))));
            stage.show();

        } catch (IOException e) { e.printStackTrace(); }
    }


}
