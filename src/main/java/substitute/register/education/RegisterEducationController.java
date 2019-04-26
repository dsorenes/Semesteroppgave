package substitute.register.education;

import employer.Industry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RegisterEducationController implements Initializable {

    @FXML
    private TextField schoolName;

    @FXML
    private TextField degree;

    @FXML
    private ComboBox<Subject> subjectDropdown;

    @FXML
    private ComboBox<String> educationLevelDropdown;

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

    private final Integer[] years = new Integer[] {2025, 2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004,
                                                   2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982,
                                                   1981, 1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963, 1962, 1961, 1960,
                                                   1959, 2025, 2024, 1958, 1957, 1956, 1955, 1954, 1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946, 1945, 1944, 1943, 1942, 1941, 1940};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIsCurrentlyStudyingCheckbox();

        initializePeriodDropdown();
        initializeEducationLevelDropdown();
    }

    void initializeEducationLevelDropdown() {
        ObservableList<EducationLevel> industries = FXCollections.observableArrayList(EnumSet.allOf(EducationLevel.class));
        ObservableList<String> descriptions = FXCollections.observableArrayList();
        industries.forEach((e) -> descriptions.add(e.getDescription()));

        educationLevelDropdown.setItems(descriptions);

    }

    void initializePeriodDropdown () {

        //Month
        ObservableList<Month> month = FXCollections.observableArrayList(EnumSet.allOf(Month.class));
        fromMonth.setItems(month);
        toMonth.setItems(month);
        //Year
        ObservableList<Integer> year = FXCollections.observableArrayList(years);
        fromYear.setItems(year);
        toYear.setItems(year);
    }

    void initializeIsCurrentlyStudyingCheckbox() {
        currentlyStudyingCheck.setOnAction(e -> {
            toMonth.setDisable(currentlyStudyingCheck.isSelected());
            toYear.setDisable(currentlyStudyingCheck.isSelected());
        });
    }
}
