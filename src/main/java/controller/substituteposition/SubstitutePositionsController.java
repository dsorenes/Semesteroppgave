package controller.substituteposition;

import model.data.employer.Industry;
import model.data.employer.Sector;
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
        posCol.setCellValueFactory(new PropertyValueFactory<>("positionTitle"));
        industryCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        sectorCol.setCellValueFactory(new PropertyValueFactory<>("sector"));
        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("to"));

    }

    @FXML
    void rightClickShowDetails(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/register/substituteposition/SubstitutePositionDisplay.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Substitute position information");
        stage.setScene(new Scene(root));
        stage.show();
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
