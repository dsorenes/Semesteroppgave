package substitute.register.education;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import substitute.register.work.Work;
import utils.Year;

import java.net.URL;
import java.time.Month;
import java.util.*;

public class RegisterEducationController implements Initializable {

    @FXML
    private TextField schoolName;

    @FXML
    private TextField degree;

    @FXML
    private ComboBox<Subject> subjectDropdown;

    @FXML
    private ComboBox<EducationLevel> educationLevelDropdown;

    @FXML
    private ComboBox<Month> fromMonth;

    @FXML
    private ComboBox<Integer> fromYear;

    @FXML
    private ComboBox<Month> toMonth;

    @FXML
    private ComboBox<Integer> toYear;

    @FXML
    private CheckBox currentlyStudyingCheck;

    @FXML
    private TableView<Education> educationTable;

    @FXML
    private TableColumn<Education, String> schoolNameCol;

    @FXML
    private TableColumn<Education, String> degreeCol;

    @FXML
    private TableColumn<Education, Subject> subjectCol;

    @FXML
    private TableColumn<Education, EducationLevel> educationLevelCol;

    @FXML
    private TableColumn<Education, String> fromCol;

    @FXML
    private TableColumn<Education, String> toCol;

    @FXML
    private TableColumn<Education, Boolean> isStudyingCol;

    @FXML
    private Button addEducation;

    public ObservableList<Education> educations = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIsCurrentlyStudyingCheckbox();
        initializeSubjectDropdown();

        initializePeriodDropdown();
        initializeEducationLevelDropdown();
        initializeEducationTable();

        addEducation.setOnAction(e -> onAddEducation());
    }

    void initializeEducationTable() {
        schoolNameCol.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        degreeCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        educationLevelCol.setCellValueFactory(new PropertyValueFactory<>("educationLevel"));
        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("to"));
        isStudyingCol.setCellValueFactory(new PropertyValueFactory<>("isCurrentlyStudying"));
    }

    void initializeEducationLevelDropdown() {
        educationLevelDropdown.getItems().setAll(EducationLevel.values());

    }

    void initializeSubjectDropdown() {
        subjectDropdown.getItems().setAll(Subject.values());
    }

    void initializePeriodDropdown () {

        //Month
        fromMonth.getItems().addAll(Month.values());
        toMonth.getItems().addAll(Month.values());
        //Year
        fromYear.getItems().addAll(Year.YEARS);
        toYear.getItems().addAll(Year.YEARS);
    }

    void initializeIsCurrentlyStudyingCheckbox() {
        currentlyStudyingCheck.setOnAction(e -> {
            toMonth.setDisable(currentlyStudyingCheck.isSelected());
            toYear.setDisable(currentlyStudyingCheck.isSelected());
        });
    }

    void onAddEducation() {
        Education education = new Education(schoolName.getText(), subjectDropdown.getValue(), educationLevelDropdown.getValue(), degree.getText(),
                                            fromMonth.getValue(), fromYear.getValue(), toMonth.getValue(), toYear.getValue(), currentlyStudyingCheck.isSelected());
        educations.add(education);

        educationTable.setItems(educations);

    }

}
