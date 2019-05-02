package controller.substitute;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.filemanager.readfromfile.ReadFromCSV;
import model.filemanager.savetofile.SaveToCSV;
import model.data.substitute.Substitute;
import utils.ClearInput;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterSubstituteController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    void onRegister() {
        Substitute sub = new Substitute();

        sub.setFirstName(RegisterContactInformationViewController.firstName.getText());
        sub.setLastName(RegisterContactInformationViewController.lastName.getText());
        sub.setDateOfBirth(RegisterContactInformationViewController.dateOfBirth.getValue());
        sub.setAddress(RegisterContactInformationViewController.address.getText());
        sub.setPhoneNumber(RegisterContactInformationViewController.phoneNumber.getText());
        sub.setEMail(RegisterContactInformationViewController.eMail.getText());

        int subID = ReadFromCSV.createIdCSV("data/substitute");
        int educationID = ReadFromCSV.createIdCSV("data/education");
        int referenceID = ReadFromCSV.createIdCSV("data/workReference");
        int workExperienceID = ReadFromCSV.createIdCSV("data/workExperience");

        sub.setID(subID);
        sub.setEducation(RegisterEducationViewController.educations, educationID);
        sub.setReferences(RegisterReferenceViewController.references, referenceID);
        sub.setWorkExperience(RegisterWorkExperienceViewController.previousWorkTable, workExperienceID);
        sub.setWorkField(RegisterContactInformationViewController.wantedField);

        SaveToCSV save = new SaveToCSV();

        List<Substitute> data = new ArrayList<>();
        data.add(sub);
        save.SaveToFile("data/education", sub.getEducation());
        save.SaveToFile("data/workReference", sub.getReferences());
        save.SaveToFile("data/workExperience", sub.getWorkExperience());
        save.SaveToFile("data/substitute", data);

        ClearInput.clearInputFields(RegisterContactInformationViewController.firstName, RegisterContactInformationViewController.lastName, RegisterContactInformationViewController.eMail,
                                    RegisterContactInformationViewController.address, RegisterContactInformationViewController.phoneNumber);
        ClearInput.clearLists(RegisterContactInformationViewController.industryListView);
        ClearInput.clearTables(RegisterEducationViewController.educationTable, RegisterReferenceViewController.referenceTableView, RegisterWorkExperienceViewController.workExperienceTable);
    }
}


