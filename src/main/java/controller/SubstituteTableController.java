package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.filemanager.readfromfile.ReadFromCSV;
import model.data.substitute.Substitute;

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
        System.out.println(s.getWantedWorkFields());
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
