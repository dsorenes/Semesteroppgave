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

    public ObservableList<WorkReference> references = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeReferenceTableView();

        addReference.setOnAction(e -> onAddReference());
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
    Button register;

    @FXML
    private RegisterEducationController RegisterEducationViewController;

    @FXML
    private RegisterWorkExperienceController RegisterWorkExperienceViewController;

    @FXML
    private RegisterContactInformationController RegisterContactInformationViewController;

    @FXML
    private RegisterWorkReferenceController RegisterReferenceViewController;


    @FXML
    void onRegister() {

        Substitute regSub = new Substitute();


            regSub.setFirstName(RegisterContactInformationViewController.firstName.getText());
            regSub.setLastName(RegisterContactInformationViewController.lastName.getText());
            regSub.setDateOfBirth(RegisterContactInformationViewController.dateOfBirth.getValue());
            regSub.setAddress(RegisterContactInformationViewController.address.getText());
            regSub.setPhoneNumber(RegisterContactInformationViewController.phoneNumber.getText());
            regSub.setEMail(RegisterContactInformationViewController.eMail.getText());

            int subID = ReadFromCSV.createIdCSV("data/substitute");
            int educationID = ReadFromCSV.createIdCSV("data/education");
            int referenceID = ReadFromCSV.createIdCSV("data/workReference");
            int workExperienceID = ReadFromCSV.createIdCSV("data/workExperience");

            regSub.setID(subID);
            regSub.setEducation(RegisterEducationViewController.educations, educationID);
            regSub.setReferences(RegisterReferenceViewController.references, referenceID);
            regSub.setWorkExperience(RegisterWorkExperienceViewController.previousWorkTable, workExperienceID);
            regSub.setWorkField(RegisterContactInformationViewController.wantedField);
/*
        SaveToCSV save = new SaveToCSV();

        List<Substitute> data = new ArrayList<>();
        data.add(regSub);
        save.SaveToFile("data/education", regSub.getEducation());
        save.SaveToFile("data/workReference", regSub.getReferences());
        save.SaveToFile("data/workExperience", regSub.getWorkExperience());
        save.SaveToFile("data/substitute", data);

        ClearInput.clearInputFields(RegisterContactInformationViewController.firstName, RegisterContactInformationViewController.lastName, RegisterContactInformationViewController.eMail,
                RegisterContactInformationViewController.address, RegisterContactInformationViewController.phoneNumber);
        ClearInput.clearLists(RegisterContactInformationViewController.industryListView);
        ClearInput.clearTables(RegisterEducationViewController.educationTable, RegisterReferenceViewController.referenceTableView, RegisterWorkExperienceViewController.workExperienceTable);
   */



   }

   public Substitute getSubContactInfo() {

       Substitute sub = new Substitute();

       try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substitute/contact/RegisterContactInformationView.fxml"));
           Parent root = loader.load();
           RegisterContactInformationController controller = loader.<RegisterContactInformationController>getController();
           controller.setData(sub);
       } catch ( IOException e ) {System.out.println(e.toString()); }

       return sub;

    }




}
