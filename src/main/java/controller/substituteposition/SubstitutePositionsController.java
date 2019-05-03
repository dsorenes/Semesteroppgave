package controller.substituteposition;

import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.substitute.Substitute;
import model.data.substituteposition.SubstitutePosition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.filemanager.readfromfile.CSVReader;
import model.filemanager.savetofile.CSVWriter;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SubstitutePositionsController implements Initializable {

    @FXML private TableView<SubstitutePosition> substitutePositionTableView;

    @FXML private TableColumn<SubstitutePosition, String> nameCol;

    @FXML private TableColumn<SubstitutePosition, String> posCol;

    @FXML private TableColumn<SubstitutePosition, Industry> industryCol;

    @FXML private TableColumn<SubstitutePosition, Sector> sectorCol;

    @FXML private TableColumn<SubstitutePosition, String> fromCol;

    @FXML private TableColumn<SubstitutePosition, String> toCol;

    @FXML private TableColumn<SubstitutePosition, String> locationCol;

    @FXML private TextArea description;

    @FXML private TextArea employmentConditions;

    @FXML private TextArea salaryConditions;

    @FXML private ListView<String> qualifications;

    @FXML private TextField workHours;

    @FXML private TextField contactFullName;

    @FXML private TextField contactPhone;

    @FXML private TextField contactEmail;

    @FXML private Button saveChanges;

    SubstitutePosition substitutePosition;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
        populateTableView();

        substitutePositionTableView.getSelectionModel().selectedItemProperty().addListener(e -> onSelectDisplayInformation());
        saveChanges.setOnAction(e -> onSaveChanges());


    }

    private void onSaveChanges() {
        String descript = substitutePosition.getDescription();
        substitutePosition.setDescription(description.getText());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getDescription(), substitutePosition.getDescription());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getEmploymentConditions(), employmentConditions.getText());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getSalaryConditions(), salaryConditions.getText());
        String qual = substitutePosition.getQualificationsNeeded();
        substitutePosition.setQualifications(qualifications.getItems());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), qual, substitutePosition.getQualificationsNeeded());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getWorkHours(), workHours.getText());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getContactName(), contactFullName.getText());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getContactPhone(), contactPhone.getText());
        CSVWriter.editLine("data/position/position", substitutePosition.getID(), substitutePosition.getContactEMail(), contactEmail.getText());
    }
    private void onSelectDisplayInformation() {
        substitutePosition = substitutePositionTableView.getSelectionModel().getSelectedItem();
        description.setText(substitutePosition.getDescription());
        employmentConditions.setText(substitutePosition.getEmploymentConditions());
        salaryConditions.setText(substitutePosition.getSalaryConditions());
        qualifications.getItems().setAll(substitutePosition.getQualifications());
        workHours.setText(substitutePosition.getWorkHours());
        contactFullName.setText(substitutePosition.getContactName());
        contactPhone.setText(substitutePosition.getContactPhone());
        contactEmail.setText(substitutePosition.getContactEMail());
    }

    private void initTable() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().getEmployer().setCompanyName(t.getNewValue());
            CSVWriter.editLine("data/employer/employer", t.getRowValue().getEmployerID(), oldValue, t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), oldValue, t.getNewValue());
        });

        posCol.setCellValueFactory(new PropertyValueFactory<>("positionTitle"));
        posCol.setCellFactory(TextFieldTableCell.forTableColumn());
        posCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setPositionTitle(t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), oldValue, t.getNewValue());
        });

        industryCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        industryCol.setCellFactory(ComboBoxTableCell.forTableColumn(Industry.values()));
        industryCol.setOnEditCommit(t -> {
            Industry old = t.getOldValue();
            t.getRowValue().setPosition(t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), old.toString(), t.getNewValue().toString());
        });
        sectorCol.setCellValueFactory(new PropertyValueFactory<>("sector"));
        sectorCol.setCellFactory(ComboBoxTableCell.forTableColumn(Sector.values()));
        sectorCol.setOnEditCommit(t -> {
            Sector old = t.getOldValue();
            t.getRowValue().setSector(t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), old.toString(), t.getNewValue().toString());
        });
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationCol.setCellFactory(TextFieldTableCell.forTableColumn());
        locationCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setLocation(t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), oldValue, t.getNewValue());
        });

        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        fromCol.setCellFactory(TextFieldTableCell.forTableColumn());
        fromCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setFrom(t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
        toCol.setCellFactory(TextFieldTableCell.forTableColumn());
        toCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setTo(t.getNewValue());
            CSVWriter.editLine("data/position/position", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
    }

    private void populateTableView() {
        ObservableList<SubstitutePosition> subs = null;
        try {
            subs = FXCollections.observableArrayList(CSVReader.parseToSubstitutePosition("data/position/position"));
            substitutePositionTableView.setItems(subs);
        } catch (IOException e) {
            System.out.println("SUBSTITUTERROREREF");
        }
    }
}
