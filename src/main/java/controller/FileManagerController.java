package controller;

import static utils.FileGrabber.getFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.FileNotFoundException;


public class FileManagerController {

    @FXML
    private void SubSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void EduSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void WorkSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void RefSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void EmpSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void PosSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void AssSave(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void SubOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void EduOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void WorkOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void RefOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void EmpOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void PosOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }

    @FXML
    private void AssOpen(ActionEvent event) {
        try {
            getFile();
        } catch (FileNotFoundException e) {}
    }
}
