package employer.substituteposition.register;

import employer.Industry;
import employer.Sector;
import employer.substituteposition.SubstitutePosition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import readfromfile.ReadFromCSV;

import java.net.URL;
import java.util.ArrayList;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        populateTableView();
    }

    private void initCol() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        posCol.setCellValueFactory(new PropertyValueFactory<>("positionTitle"));
        industryCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        sectorCol.setCellValueFactory(new PropertyValueFactory<>("sector"));
        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
    }

    private void populateTableView() {
        ReadFromCSV read = new ReadFromCSV();
        ArrayList<String> positions = read.ReadFromFile("data/position/position");
        ObservableList<SubstitutePosition> subs = FXCollections.observableArrayList(SubstitutePosition.positionFromCSV(positions));
        substitutePositionTableView.setItems(subs);
    }
}
