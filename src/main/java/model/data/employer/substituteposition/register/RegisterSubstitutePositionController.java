package model.data.employer.substituteposition.register;

import model.data.employer.Industry;
import model.data.employer.Sector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.utils.Year;

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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIndustryDropdown();

        initializePeriodDropdown();
        initializeSectorDropdown();
    }

    void initializeSectorDropdown() {
        sectorDropdown.getItems().setAll(Sector.values());

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
