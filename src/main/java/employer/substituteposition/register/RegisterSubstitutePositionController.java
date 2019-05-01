package employer.substituteposition.register;

import employer.register.Employer;
import employer.Industry;
import employer.Sector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;
import readfromfile.ReadFromCSV;
import utils.Year;

import java.net.URL;
import java.time.Month;
import java.util.ResourceBundle;

public class RegisterSubstitutePositionController implements Initializable {

    @FXML
    private ComboBox<Month> fromMonth;

    @FXML
    private ComboBox<Month> toMonth;

    @FXML
    private ComboBox<Integer> fromYear;

    @FXML
    private ComboBox<Integer> toYear;

    @FXML
    private ComboBox<Sector> sectorDropdown;

    @FXML
    private ComboBox<Industry> industryDropdown;

    @FXML
    private ListView<Employer> employerList;

    @FXML
    private TextField selectedEmployer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIndustryDropdown();

        initializePeriodDropdown();
        initializeSectorDropdown();
        populateEmployerList();

        employerList.getSelectionModel().selectedItemProperty().addListener(e -> {
            selectEmployer();
            Employer employer = employerList.getSelectionModel().getSelectedItem();
            System.out.println(employer);
        });

    }

    void initializeSectorDropdown() {
        sectorDropdown.getItems().setAll(Sector.values());

    }

    void populateEmployerList() {
        ObservableList<Employer> employers = FXCollections.observableArrayList(ReadFromCSV.getEmployers());
        employerList.setItems(employers);
        employerList.setCellFactory(e -> new ListCell<>() {
          @Override
          protected void updateItem(Employer item, boolean empty) {
              super.updateItem(item, empty);
              if (empty || item == null) {
                  setText(null);
                  setGraphic(null);
              } else {

                setText(item.getCompanyName());
              }

          }
        });
    }

    void selectEmployer() {
        String employer = employerList.getSelectionModel().getSelectedItem().getCompanyName();
        selectedEmployer.setText(employer);
    }

    void initializeIndustryDropdown() {
        industryDropdown.getItems().setAll(Industry.values());
    }

    void initializePeriodDropdown () {

        //Month
        fromMonth.getItems().addAll(Month.values());
        toMonth.getItems().addAll(Month.values());
        //Year
        fromYear.getItems().addAll(Year.YEARS);
        toYear.getItems().addAll(Year.YEARS);
    }
}
