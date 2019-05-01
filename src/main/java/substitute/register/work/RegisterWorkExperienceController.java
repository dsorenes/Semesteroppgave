package substitute.register.work;

import employer.Industry;
import employer.Sector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.ClearInput;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class RegisterWorkExperienceController implements Initializable {

    @FXML
    private TextField inputCompanyName;

    @FXML
    private TextField inputPositionName;

    @FXML
    private DatePicker inputEmployedFrom;

    @FXML
    private DatePicker inputEmployedTo;

    @FXML
    private ComboBox<Industry> industryDropdown;

    @FXML
    private ComboBox<Sector> sectorDropdown;

    @FXML
    private Button addWorkExperience;

    @FXML
    public TableView<Work> workExperienceTable;

    @FXML
    private TableColumn<Work, String> companyCol;

    @FXML
    private TableColumn<Work, String> positionCol;

    @FXML
    private TableColumn<Work, Industry> industryCol;

    @FXML
    private TableColumn<Work, Sector> sectorCol;

    @FXML
    private TableColumn<Work, LocalDate> fromCol;

    @FXML
    private TableColumn<Work, LocalDate> toCol;

    public ObservableList<Work> previousWorkTable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeIndustryDropdown();
        initializeSectorDropdown();
        initCol();

    }

    private void initializeIndustryDropdown() {
        industryDropdown.getItems().setAll(Industry.values());

    }

    private void initializeSectorDropdown() {
        sectorDropdown.getItems().addAll(Sector.values());
    }

    private void initCol() {

        companyCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        industryCol.setCellValueFactory(new PropertyValueFactory<>("industry"));
        sectorCol.setCellValueFactory(new PropertyValueFactory<>("sector"));
        fromCol.setCellValueFactory(new PropertyValueFactory<>("employedFrom"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("employedTo"));

    }

    @FXML
    void onAddWorkExperience() {

        Work previousWork = new Work();


        previousWork.setCompanyName(inputCompanyName.getText());
        previousWork.setPosition(inputPositionName.getText());
        previousWork.setSector(sectorDropdown.getValue());
        previousWork.setIndustry(industryDropdown.getValue());
        previousWork.setEmployedFrom(inputEmployedFrom.getValue());
        previousWork.setEmployedTo(inputEmployedTo.getValue());

        previousWorkTable.add(previousWork);
        workExperienceTable.setItems(previousWorkTable);

        ClearInput.clearInputFields(inputCompanyName, inputPositionName);
        ClearInput.clearDropdowns(industryDropdown, sectorDropdown);

    }
}
