package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

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
    public void saveFile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.setTitle("Save");
        fc.setInitialDirectory(new File("."));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

        } else {

        }
    }

    @FXML
    public void openFile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.setTitle("Open");
        fc.setInitialDirectory(new File("."));
        File selectedFile = fc.showOpenDialog(null);

    }



}
