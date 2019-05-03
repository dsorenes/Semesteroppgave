package controller.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.substitute.education.Education;
import model.data.substitute.education.EducationLevel;
import model.data.substitute.education.Subject;
import model.data.substitute.references.WorkReference;
import model.data.substitute.work.Work;
import model.filemanager.readfromfile.CSVReader;
import model.data.substitute.Substitute;
import model.filemanager.savetofile.CSVWriter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SubstituteTableController implements Initializable {

    @FXML private TableView<Substitute> substituteTable;

    @FXML private TableColumn<Substitute, String> firstNameCol;

    @FXML private TableColumn<Substitute, String> lastNameCol;

    @FXML private TableColumn<Substitute, String> addressCol;

    @FXML private TableColumn<Substitute, LocalDate> bornCol;

    @FXML private TableColumn<Substitute, String> eMailCol;

    @FXML private TableColumn<Substitute, String> phoneCol;

    @FXML private TableColumn<Substitute, Boolean> employedCol;

    @FXML public TableView<Education> educationTable;

    @FXML private TableColumn<Education, String> schoolNameCol;

    @FXML private TableColumn<Education, String> degreeCol;

    @FXML private TableColumn<Education, Subject> subjectCol;

    @FXML private TableColumn<Education, EducationLevel> educationLevelCol;

    @FXML private TableColumn<Education, String> eduFromCol;

    @FXML private TableColumn<Education, String> eduToCol;

    @FXML private TableColumn<Education, Boolean> isStudyingCol;

    @FXML public TableView<WorkReference> referenceTableView;

    @FXML private TableColumn<WorkReference, String> fullNameCol;

    @FXML private TableColumn<WorkReference, String> phoneNumberCol;

    @FXML private TableColumn<WorkReference, String> MailCol;

    @FXML private TableColumn<WorkReference, String> employerCol;

    @FXML public TableView<Work> workExperienceTable;

    @FXML private TableColumn<Work, String> companyCol;

    @FXML private TableColumn<Work, String> positionCol;

    @FXML private TableColumn<Work, Industry> industryCol;

    @FXML private TableColumn<Work, Sector> sectorCol;

    @FXML private TableColumn<Work, LocalDate> fromCol;

    @FXML private TableColumn<Work, LocalDate> toCol;

    @FXML private MenuItem rightClickDeleteReference;

    @FXML private MenuItem rightClickDeleteSubstitute;

    @FXML private MenuItem rightClickDeleteEducation;

    @FXML private MenuItem rightClickDeleteWork;


    private void initializeSubstituteTable() {
        ObservableList<Substitute> substitutes;
        substitutes = FXCollections.observableArrayList(CSVReader.parseSubstitute());
        substituteTable.getItems().setAll(substitutes);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeSubstituteCol();
        initializeWorkExperienceCol();
        initializeEducationCol();
        initializeReferenceCol();
        initializeSubstituteTable();

        substituteTable.getSelectionModel().selectedItemProperty().addListener(e -> onSubstituteTableSelection());
        onRightClickDeleteReference();
        onRightClickDeleteSubstitute();
        onRightClickDeleteWork();
        onRightClickDeleteEducation();

    }

    private void onSubstituteTableSelection() {
        Substitute s = substituteTable.getSelectionModel().getSelectedItem();
        if (s != null) {
            populateTablesOnSelection(s);
        }

    }

    private void onRightClickDeleteReference() {
        rightClickDeleteReference.setOnAction(e -> {
            CSVWriter.deleteLine("data/workReference", referenceTableView.getSelectionModel().getSelectedItem().getID(), 0);
        });
    }

    private void onRightClickDeleteWork() {
        rightClickDeleteWork.setOnAction(e -> {
            CSVWriter.deleteLine("data/workExperience", workExperienceTable.getSelectionModel().getSelectedItem().getID(), 0);
        });
    }

    private void onRightClickDeleteSubstitute() {
        rightClickDeleteSubstitute.setOnAction(e -> {
            CSVWriter.deleteLine("data/substitute", substituteTable.getSelectionModel().getSelectedItem().getID(), 0);
        });
    }

    private void onRightClickDeleteEducation() {
        rightClickDeleteEducation.setOnAction(e -> {
            CSVWriter.deleteLine("data/education", educationTable.getSelectionModel().getSelectedItem().getID(), 0);
        });
    }

    private void populateTablesOnSelection(Substitute sub) {
        referenceTableView.getItems().setAll(sub.getReferences());
        workExperienceTable.getItems().setAll(sub.getWorkExperience());
        educationTable.getItems().setAll(sub.getEducation());
    }

    private void initializeSubstituteCol() {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setFirstName(t.getNewValue());
            CSVWriter.editLine("data/substitute", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setLastName(t.getNewValue());
            CSVWriter.editLine("data/substitute", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        bornCol.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setAddress(t.getNewValue());
            CSVWriter.editLine("data/substitute", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        eMailCol.setCellValueFactory(new PropertyValueFactory<>("eMail"));
        eMailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        eMailCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setEMail(t.getNewValue());
            CSVWriter.editLine("data/substitute", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setPhoneNumber(t.getNewValue());
            CSVWriter.editLine("data/substitute", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        employedCol.setCellValueFactory(new PropertyValueFactory<>("isEmployed"));
        employedCol.setCellFactory(ComboBoxTableCell.forTableColumn(Boolean.FALSE, Boolean.TRUE));
        employedCol.setOnEditCommit(t -> {
            boolean oldValue = t.getOldValue();
            t.getRowValue().setIsEmployed(t.getNewValue());
            CSVWriter.editLine("data/substitute", t.getRowValue().getID(), Boolean.toString(oldValue), Boolean.toString(t.getNewValue()));
        });
    }
    private void initializeReferenceCol() {
        employerCol.setCellValueFactory(new PropertyValueFactory<>("employerName"));
        employerCol.setCellFactory(TextFieldTableCell.forTableColumn());
        employerCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setEmployerName(t.getNewValue());
            CSVWriter.editLine("data/workReference", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        fullNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        fullNameCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setFullName(t.getNewValue());
            CSVWriter.editLine("data/workReference", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setPhoneNumber(t.getNewValue());
            CSVWriter.editLine("data/workReference", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        MailCol.setCellValueFactory(new PropertyValueFactory<>("eMail"));
        MailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        MailCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setEMail(t.getNewValue());
            CSVWriter.editLine("data/workReference", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
    }

    private void initializeWorkExperienceCol() {
        companyCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        companyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        companyCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setCompanyName(t.getNewValue());
            CSVWriter.editLine("data/workExperience", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        positionCol.setCellFactory(TextFieldTableCell.forTableColumn());
        positionCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setPosition(t.getNewValue());
            CSVWriter.editLine("data/workExperience", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        industryCol.setCellValueFactory(new PropertyValueFactory<>("industry"));
        industryCol.setCellFactory(ComboBoxTableCell.forTableColumn(Industry.values()));
        industryCol.setOnEditCommit(t -> {
            Industry old = t.getOldValue();
            t.getRowValue().setIndustry(t.getNewValue());
            CSVWriter.editLine("data/workExperience", t.getRowValue().getID(), old.toString(), t.getNewValue().toString());
        });
        sectorCol.setCellValueFactory(new PropertyValueFactory<>("sector"));
        sectorCol.setCellFactory(ComboBoxTableCell.forTableColumn(Sector.values()));
        sectorCol.setOnEditCommit(t -> {
            Sector old = t.getOldValue();
            t.getRowValue().setSector(t.getNewValue());
            CSVWriter.editLine("data/workExperience", t.getRowValue().getID(), old.toString(), t.getNewValue().toString());
        });
        fromCol.setCellValueFactory(new PropertyValueFactory<>("employedFrom"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("employedTo"));
    }

    void initializeEducationCol() {
        schoolNameCol.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        schoolNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        schoolNameCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setSchoolName(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        degreeCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
        degreeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        degreeCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setDegree(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        subjectCol.setCellValueFactory(new PropertyValueFactory<>("subject"));
        subjectCol.setCellFactory(ComboBoxTableCell.forTableColumn(Subject.values()));
        subjectCol.setOnEditCommit(t -> {
            Subject oldValue = t.getOldValue();
            t.getRowValue().setSubject(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), oldValue.toString(), t.getNewValue().toString());
        });
        educationLevelCol.setCellValueFactory(new PropertyValueFactory<>("educationLevel"));
        educationLevelCol.setCellFactory(ComboBoxTableCell.forTableColumn(EducationLevel.values()));
        educationLevelCol.setOnEditCommit(t -> {
            EducationLevel oldValue = t.getOldValue();
            t.getRowValue().setEducationLevel(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), oldValue.toString(), t.getNewValue().toString());
        });
        eduFromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        eduFromCol.setCellFactory(TextFieldTableCell.forTableColumn());
        eduFromCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setFrom(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        eduToCol.setCellValueFactory(new PropertyValueFactory<>("to"));
        eduToCol.setCellFactory(TextFieldTableCell.forTableColumn());
        eduToCol.setOnEditCommit(t -> {
            String oldValue = t.getOldValue();
            t.getRowValue().setTo(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), oldValue, t.getNewValue());
        });
        isStudyingCol.setCellValueFactory(new PropertyValueFactory<>("isCurrentlyStudying"));
        isStudyingCol.setCellFactory(ComboBoxTableCell.forTableColumn(Boolean.FALSE, Boolean.TRUE));
        isStudyingCol.setOnEditCommit(t -> {
            boolean oldValue = t.getOldValue();
            t.getRowValue().setIsCurrentlyStudying(t.getNewValue());
            CSVWriter.editLine("data/education", t.getRowValue().getID(), Boolean.toString(oldValue), Boolean.toString(t.getNewValue()));
        });
    }
}
