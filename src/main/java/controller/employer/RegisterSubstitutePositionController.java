package controller.employer;

import model.data.employer.Employer;
import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.substituteposition.SubstitutePosition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.filemanager.readfromfile.CSVReader;
import model.filemanager.savetofile.CSVWriter;
import utils.ClearInput;
import utils.Year;

import java.net.URL;
import java.time.Month;
import java.util.ArrayList;
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

    @FXML
    private TextField posLocation;

    @FXML
    private TextField posHours;

    @FXML
    private TextArea posConditions;

    @FXML
    private TextArea posSalary;

    @FXML
    private TextField positionTitle;

    @FXML
    private TextArea posDescription;

    @FXML
    private TextField posQualityField;

    @FXML
    private Button addQualification;

    @FXML
    private ListView<String> qualificationList;

    @FXML
    private TextField contactName;

    @FXML
    private TextField contactPhone;

    @FXML
    private TextField contactEmail;

    @FXML
    private Button createPosition;

    ObservableList<String> qualifications = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeDropdowns();

        populateEmployerList();
        selectedEmployer();

        addQualification.setOnAction(e -> onAddQualification());

        createPosition.setOnAction(e -> onCreatePosition());

    }

    private void onAddQualification() {
        qualifications.add(posQualityField.getText());
        qualificationList.getItems().setAll(qualifications);
        ClearInput.clearInputFields(posQualityField);
    }

    private void onCreatePosition() {
        int positionID = CSVReader.createIdCSV("data/position/position");
        SubstitutePosition position = new SubstitutePosition(employerList.getSelectionModel().getSelectedItem(), industryDropdown.getValue(), sectorDropdown.getValue(), fromMonth.getValue(), fromYear.getValue(),
                                                             toMonth.getValue(), toYear.getValue());
        position.setID(positionID);
        position.setLocation(posLocation.getText());
        position.setEmploymentConditions(posConditions.getText());
        position.setWorkHours(posHours.getText());
        position.setSalaryConditions(posSalary.getText());
        position.setPositionTitle(positionTitle.getText());
        position.setDescription(posDescription.getText());
        position.setQualifications(qualifications);
        position.setContactName(contactName.getText());
        position.setContactPhone(contactPhone.getText());
        position.setContactEMail(contactEmail.getText());

        ArrayList<SubstitutePosition> pos = new ArrayList<>();
        pos.add(position);

        CSVWriter save = new CSVWriter();
        save.WriteToFile("data/position/position", pos);

        ClearInput.clearDropdowns(fromMonth, fromYear, toMonth, toYear, industryDropdown, sectorDropdown);
        ClearInput.clearInputFields(selectedEmployer, posLocation, posHours, positionTitle, contactEmail, contactName, contactPhone);
        ClearInput.clearLists(qualificationList);
        ClearInput.clearTextArea(posConditions, posDescription, posSalary, posDescription);
        ClearInput.clearListSelection(employerList);
    }

    private void selectedEmployer() {
        employerList.getSelectionModel().selectedItemProperty().addListener(e -> {
            if (employerList.getSelectionModel().getSelectedItem() != null) {
                selectedEmployer.setText(employerList.getSelectionModel().getSelectedItem().getCompanyName());
            }
        });
    }

    private void populateEmployerList() {
        ObservableList<Employer> employers = FXCollections.observableArrayList(CSVReader.getEmployersFomCSV());
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

    private void initializeDropdowns () {

        //Month
        fromMonth.getItems().addAll(Month.values());
        toMonth.getItems().addAll(Month.values());
        //Year
        fromYear.getItems().addAll(Year.YEARS);
        toYear.getItems().addAll(Year.YEARS);

        industryDropdown.getItems().setAll(Industry.values());

        sectorDropdown.getItems().setAll(Sector.values());
    }
}
