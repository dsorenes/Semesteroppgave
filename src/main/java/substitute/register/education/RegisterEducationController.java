package substitute.register.education;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIsCurrentlyStudyingCheckbox();
        initializeSubjectDropdown();

        initializePeriodDropdown();
        initializeEducationLevelDropdown();
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

}
