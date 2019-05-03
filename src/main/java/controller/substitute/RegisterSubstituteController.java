package controller.substitute;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.filemanager.readfromfile.CSVReader;
import model.filemanager.savetofile.CSVWriter;
import model.data.substitute.Substitute;
import model.utils.ClearInput;

import java.io.IOException;
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

        int subID = 1;
        int workExperienceID = 1;
        int educationID = 1;
        int referenceID = 1;
        try {
            subID = CSVReader.createIdCSV("data/substitute");
            educationID = CSVReader.createIdCSV("data/education");
            referenceID = CSVReader.createIdCSV("data/workReference");
            workExperienceID = CSVReader.createIdCSV("data/workExperience");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sub.setID(subID);
        sub.setEducation(RegisterEducationViewController.educations, educationID);
        sub.setReferences(RegisterReferenceViewController.references, referenceID);
        sub.setWorkExperience(RegisterWorkExperienceViewController.previousWorkTable, workExperienceID);
        sub.setWantedWorkFields(RegisterContactInformationViewController.wantedField);

        CSVWriter save = new CSVWriter();

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


