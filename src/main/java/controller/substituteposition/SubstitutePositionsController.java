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
import model.filemanager.readfromfile.ReadFromCSV;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
        populateTableView();

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
        ReadFromCSV read = new ReadFromCSV();
        ObservableList<SubstitutePosition> subs = FXCollections.observableArrayList(ReadFromCSV.substitutePositionFromCSV("data/position/position"));
        substitutePositionTableView.setItems(subs);
    }
}
