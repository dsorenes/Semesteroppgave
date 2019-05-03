package controller.substitute;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import model.data.substitute.Substitute;
import model.filemanager.readfromfile.CSVReader;
import utils.ClearInput;
import utils.Year;

import model.data.substitute.education.Education;
import model.data.substitute.education.EducationLevel;
import model.data.substitute.education.Subject;

import java.io.IOException;
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
    public TableView<Education> educationTable;

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

    public void setSubstitute(Substitute substitute) {
        this.substitute = substitute;
    }

    public Substitute substitute;

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

        Education education = new Education();

        education.setSchoolName(schoolName.getText());
        education.setSubject(subjectDropdown.getValue());
        education.setEducationLevel(educationLevelDropdown.getValue());
        education.setDegree(degree.getText());
        education.setFrom(fromMonth.getValue() + ", " + fromYear.getValue());
        education.setTo(fromMonth.getValue() + ", " + toYear.getValue());
        education.setIsCurrentlyStudying(currentlyStudyingCheck.isSelected());

        System.out.println(education);

        educations.add(education);
        educationTable.setItems(educations);

        ClearInput.clearInputFields(schoolName, degree);
        ClearInput.clearDropdowns(subjectDropdown, educationLevelDropdown, fromMonth, fromYear, toMonth, toYear);

    }

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void NextPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substitute/work/RegisterWorkExperienceView.fxml"));
            Parent root = loader.load();
            rootPane.getChildren().setAll(root);

            RegisterWorkExperienceController controller = loader.getController();
            int educationID = CSVReader.createIdCSV("data/education");
            this.substitute.setEducation(educations, educationID);
            controller.setSubstitute(this.substitute);
        } catch (IOException e) { e.printStackTrace(); }
    }


}
