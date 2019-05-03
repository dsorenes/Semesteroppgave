package controller.substitute;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import model.data.employer.Industry;
import model.data.employer.Sector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.data.substitute.Substitute;
import model.filemanager.readfromfile.CSVReader;
import utils.ClearInput;
import utils.DateTableFormat;
import model.data.substitute.work.Work;

import java.io.IOException;
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

    public Substitute substitute;

    public void setSubstitute(Substitute substitute) {
        this.substitute = substitute;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIndustryDropdown();
        initializeSectorDropdown();
        initCol();

        DateTableFormat.setFormatTo(fromCol, toCol);

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

    void initializeIndustryDropdown() {
        industryDropdown.getItems().setAll(Industry.values());

    }

    void initializeSectorDropdown() {
        sectorDropdown.getItems().addAll(Sector.values());
    }

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void NextPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substitute/references/RegisterReferenceView.fxml"));
            Parent root = loader.load();
            rootPane.getChildren().setAll(root);

            RegisterWorkReferenceController controller = loader.getController();
            int workExperienceID = CSVReader.createIdCSV("data/workExperience");
            this.substitute.setWorkExperience(previousWorkTable, workExperienceID);
            controller.setSubstitute(this.substitute);

        } catch (IOException e) { e.printStackTrace(); }
    }


}
