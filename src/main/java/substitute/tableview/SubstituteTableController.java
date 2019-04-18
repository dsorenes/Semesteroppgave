package substitute.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import readfromfile.ReadFromCSV;
import substitute.register.Substitute;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SubstituteTableController implements Initializable {

    @FXML
    private TableView<Substitute> substituteTable;

    @FXML
    private TableColumn<Substitute, String> firstNameCol;

    @FXML
    private TableColumn<Substitute, String> lastNameCol;

    private void initializeSubstituteTable() {
        ObservableList<Substitute> list = FXCollections.observableArrayList();
        ReadFromCSV read = new ReadFromCSV();
//        read.ReadFromFile("substitute");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        initializeSubstituteTable();
    }
}
