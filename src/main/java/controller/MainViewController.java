package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainViewController implements Initializable {


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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substituteposition/RegisterSubstitutePositionView.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void AvailableSubstitutes(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tableview/SubstituteTableView.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void AvailableSubstitutePositions(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substituteposition/SubstitutePositionsView.fxml"));
            ChangeableView.setCenter(loader.load());
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FileManager.fxml"));
            ChangeableView.setCenter(loader.load());
        } catch (IOException e) { e.printStackTrace(); }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
