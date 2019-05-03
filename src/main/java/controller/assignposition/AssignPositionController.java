package controller.assignposition;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import model.data.assignedposition.AssignedPosition;
import model.data.employer.Industry;
import model.data.substitute.Substitute;
import model.data.substituteposition.SubstitutePosition;
import model.filemanager.readfromfile.CSVReader;
import model.filemanager.savetofile.CSVWriter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AssignPositionController implements Initializable {

    @FXML
    private TableView<SubstitutePosition> substitutePositionTableView;

    @FXML
    private TableColumn<SubstitutePosition, String> companyCol;

    @FXML
    private TableColumn<SubstitutePosition, String> positionCol;

    @FXML
    private TableColumn<SubstitutePosition, Industry> industryCol;

    @FXML
    private TableColumn<SubstitutePosition, String> fromCol;

    @FXML
    private TableColumn<SubstitutePosition, String> toCol;

    @FXML
    private TableView<Substitute> substituteTableView;

    @FXML
    private TableColumn<Substitute, String> firstNameCol;

    @FXML
    private TableColumn<Substitute, String> lastNameCol;


    private void initTable() {
        companyCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("positionTitle"));
        industryCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("to"));

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    }

    private void populateTableView() {
        ObservableList<SubstitutePosition> subs = FXCollections.observableArrayList(CSVReader.parseToSubstitutePosition("data/position/position"));
        substitutePositionTableView.setItems(subs);
    }

    private void initializeSubstituteTable() {
        ObservableList<Substitute> substitutes;
        substitutes = FXCollections.observableArrayList(CSVReader.parseSubstitute());
        substituteTableView.getItems().setAll(substitutes);
    }

    public void AssignSubstitute(ActionEvent event) {
        int assignedID = 1;
        AssignedPosition job = new AssignedPosition();

        assignedID = CSVReader.createIdCSV("data/assignedposition/assignedposition");

        job.setAssignedID(assignedID);
        job.setSubstituteID(substituteTableView.getSelectionModel().getSelectedItem().getID());
        job.setSubstitutePositionID(substitutePositionTableView.getSelectionModel().getSelectedItem().getID());

        ArrayList<AssignedPosition> pos = new ArrayList<>();
        pos.add(job);

        CSVWriter save = new CSVWriter();
        save.SaveToFile("data/assignedposition/assignedposition", pos);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
        initializeSubstituteTable();
        populateTableView();

    }

}
