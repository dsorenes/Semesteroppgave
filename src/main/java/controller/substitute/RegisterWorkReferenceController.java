package controller.substitute;

import controller.substitute.RegisterContactInformationController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.data.substitute.Substitute;
import model.data.substitute.work.Work;
import model.data.substitute.education.Education;
import model.data.substitute.references.WorkReference;

import model.filemanager.readfromfile.ReadFromCSV;
import model.filemanager.savetofile.SaveToCSV;

import utils.ClearInput;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterWorkReferenceController implements Initializable {

    @FXML
    private TextField referenceName;

    @FXML
    private TextField referencePhone;

    @FXML
    private TextField referenceEmail;

    @FXML
    private TextField referenceEmployer;

    @FXML
    public TableView<WorkReference> referenceTableView;

    @FXML
    private TableColumn<WorkReference, String> fullNameCol;

    @FXML
    private TableColumn<WorkReference, String> phoneNumberCol;

    @FXML
    private TableColumn<WorkReference, String> eMailCol;

    @FXML
    private TableColumn<WorkReference, String> employerCol;

    @FXML
    private Button addReference;

    @FXML
    public Button register;

    public ObservableList<WorkReference> references = FXCollections.observableArrayList();

    public Substitute substitute;

    public void setSubstitute(Substitute substitute) {
        this.substitute = substitute;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeReferenceTableView();

        addReference.setOnAction(e -> onAddReference());
        register.setOnAction(e -> onRegister());
    }

    void initializeReferenceTableView() {
        employerCol.setCellValueFactory(new PropertyValueFactory<>("employerName"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        eMailCol.setCellValueFactory(new PropertyValueFactory<>("eMail"));
    }

    void onAddReference() {
        references.add(new WorkReference(referenceName.getText(), referencePhone.getText(), referenceEmail.getText(), referenceEmployer.getText()));
        referenceTableView.setItems(references);
        ClearInput.clearInputFields(referenceName, referenceEmail, referenceEmployer, referencePhone);
    }



    @FXML
    void onRegister() {
        int referenceID = ReadFromCSV.createIdCSV("data/workReference");
        int subID = ReadFromCSV.createIdCSV("data/substitute");
        this.substitute.setReferences(references, referenceID);
        this.substitute.setID(subID);
        this.substitute.getEducation().forEach(e -> e.setSubstituteID(this.substitute.getID()));
        this.substitute.getWorkExperience().forEach(e -> e.setSubstituteID(this.substitute.getID()));
        this.substitute.getReferences().forEach(e -> e.setSubstituteID(this.substitute.getID()));

        SaveToCSV save = new SaveToCSV();
        List<Substitute> data = new ArrayList<>();
        data.add(substitute);
        save.SaveToFile("data/education", substitute.getEducation());
        save.SaveToFile("data/workReference", substitute.getReferences());
        save.SaveToFile("data/workExperience", substitute.getWorkExperience());
        save.SaveToFile("data/substitute", data);

    }

}