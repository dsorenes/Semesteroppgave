package substitute.register;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import readfromfile.ReadFromCSV;
import savetofile.SaveToCSV;
import substitute.register.education.RegisterEducationController;
import substitute.register.references.RegisterWorkReferenceController;
import substitute.register.work.RegisterWorkExperienceController;
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
        Substitute sub = new Substitute(RegisterContactInformationViewController.firstName.getText(), RegisterContactInformationViewController.lastName.getText(),
                RegisterContactInformationViewController.dateOfBirth.getValue(), RegisterContactInformationViewController.address.getText(),
                RegisterContactInformationViewController.phoneNumber.getText(), RegisterContactInformationViewController.eMail.getText());

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


