package substitute.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import readfromfile.ReadFromCSV;
import substitute.register.Substitute;
import substitute.register.references.WorkReference;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SubstituteTableController implements Initializable {

    @FXML
    private TableView<Substitute> substituteTable;

    @FXML
    private TableColumn<Substitute, String> firstNameCol;

    @FXML
    private TableColumn<Substitute, String> lastNameCol;

    @FXML
    private TextFlow textFlow;

    private void initializeSubstituteTable() {
        ObservableList<Substitute> substitutes = FXCollections.observableArrayList(ReadFromCSV.getSubstitutesFromCSV());
        substituteTable.getItems().setAll(substitutes);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCol();
        initializeSubstituteTable();

        substituteTable.getSelectionModel().selectedItemProperty().addListener(e -> onSelection());

    }

    private void onSelection() {
        Substitute s = substituteTable.getSelectionModel().getSelectedItem();
        System.out.println(s.getEducation().get(0));
        System.out.println(s.getReferences().get(0));
    }
    private void initializeCol() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        industryCol.setCellValueFactory(new PropertyValueFactory<>("industry"));
//        sectorCol.setCellValueFactory(new PropertyValueFactory<>("sector"));
//        fromCol.setCellValueFactory(new PropertyValueFactory<>("employedFrom"));
//        toCol.setCellValueFactory(new PropertyValueFactory<>("employedTo"));
    }
}
