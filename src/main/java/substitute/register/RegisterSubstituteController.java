package substitute.register;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

import readfromfile.ReadFromCSV;
import savetofile.SaveToCSV;

import substitute.register.education.RegisterEducationController;
import substitute.register.references.RegisterWorkReferenceController;
import substitute.register.work.RegisterWorkExperienceController;

import utils.inputvalidation.InputValidation;
import utils.ClearInput;
import utils.exceptions.*;
import utils.inputvalidation.*;
import utils.errorpopup.ErrorPopup;

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

        try {

            InputValidation.checkName(RegisterContactInformationViewController.firstName.getText());
            sub.setFirstName(RegisterContactInformationViewController.firstName.getText());

            InputValidation.checkName(RegisterContactInformationViewController.lastName.getText());
            sub.setLastName(RegisterContactInformationViewController.lastName.getText());

            InputValidation.checkEmail(RegisterContactInformationViewController.eMail.getText());
            sub.setEMail(RegisterContactInformationViewController.eMail.getText());

            InputValidation.checkAddress(RegisterContactInformationViewController.address.getText());
            sub.setAddress(RegisterContactInformationViewController.address.getText());

            InputValidation.checkNumber(RegisterContactInformationViewController.phoneNumber.getText());
            sub.setPhoneNumber(RegisterContactInformationViewController.phoneNumber.getText());

            sub.setDateOfBirth(RegisterContactInformationViewController.dateOfBirth.getValue());

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
            System.out.println(sub.getID());

            ReadFromCSV read = new ReadFromCSV();

            ArrayList<String> reference = read.findAttributes("data/workReference", 1);
            ArrayList<String> edu = read.findAttributes("data/education", 1);
            ArrayList<String> wor = read.findAttributes("data/workExperience", 1);



            ClearInput.clearInputFields(RegisterContactInformationViewController.firstName,
                                        RegisterContactInformationViewController.lastName,
                                        RegisterContactInformationViewController.eMail,
                                        RegisterContactInformationViewController.address,
                                        RegisterContactInformationViewController.phoneNumber);

            ClearInput.clearLists(RegisterContactInformationViewController.industryListView);

            ClearInput.clearTables(RegisterEducationViewController.educationTable,
                                   RegisterReferenceViewController.referenceTableView,
                                   RegisterWorkExperienceViewController.workExperienceTable);



        } catch (InvalidNameException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid name", "Invalid name");
        } catch (InvalidEmailException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid eMail", "Invalid eMail");
        } catch (InvalidNumberException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid phone number", "Invalid phone number");
        } catch (InvalidAddressException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid adress", "Invalid adress");
        }

    }
}


