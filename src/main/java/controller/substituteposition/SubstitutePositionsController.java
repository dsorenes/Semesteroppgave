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
import java.util.ResourceBundle;

public class SubstitutePositionsController implements Initializable {

    @FXML
    private TableView<SubstitutePosition> substitutePositionTableView;

    @FXML
    private TableColumn<SubstitutePosition, String> nameCol;

    @FXML
    private TableColumn<SubstitutePosition, String> posCol;

    @FXML
    private TableColumn<SubstitutePosition, Industry> industryCol;

    @FXML
    private TableColumn<SubstitutePosition, Sector> sectorCol;

    @FXML
    private TableColumn<SubstitutePosition, String> fromCol;

    @FXML
    private TableColumn<SubstitutePosition, String> toCol;

    @FXML
    private MenuItem showDetailsMenu;

    @FXML
    private Label companyNameLabel;

    @FXML
    private Label positionLabel;

    @FXML
    private Label sectorLabel;

    @FXML
    private Label fromLabel;

    @FXML
    private Label toLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
        populateTableView();

        substitutePositionTableView.getSelectionModel().selectedItemProperty().addListener(e -> onSelectDisplayInformation());

    }

    private void onSelectDisplayInformation() {
        SubstitutePosition substitutePosition = substitutePositionTableView.getSelectionModel().getSelectedItem();
        companyNameLabel.setText(substitutePosition.getCompanyName());
        positionLabel.setText(substitutePosition.getPosition().toString());
        sectorLabel.setText(substitutePosition.getSector().toString());
        fromLabel.setText(substitutePosition.getFrom());
        toLabel.setText(substitutePosition.getDescription());
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
        } catch (IOException e) {
            System.out.println("SUBSTITUTERROREREF");
        }
        substitutePositionTableView.setItems(subs);
    }
}
