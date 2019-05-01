package substitute.register;

import javafx.scene.control.Alert;
import utils.exceptions.*;
import utils.inputvalidation.*;
import utils.errorpopup.ErrorPopup;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import readfromfile.ReadFromCSV;
import savetofile.SaveToCSV;
import substitute.register.education.RegisterEducationController;
import substitute.register.references.RegisterWorkReferenceController;
import substitute.register.work.RegisterWorkExperienceController;

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
                RegisterContactInformationViewController.eMail.getText(), RegisterContactInformationViewController.address.getText(), RegisterContactInformationViewController.phoneNumber.getText(),
                RegisterContactInformationViewController.dateOfBirth.getValue(), RegisterContactInformationViewController.salaryDemand.getText());

        try {

            InputValidation.checkName(RegisterContactInformationViewController.firstName.getText());
            sub.setFirstName(RegisterContactInformationViewController.eMail.getText());

            InputValidation.checkName(RegisterContactInformationViewController.lastName.getText());
            sub.setLastName(RegisterContactInformationViewController.eMail.getText());

            InputValidation.checkEmail(RegisterContactInformationViewController.eMail.getText());
            sub.setEMail(RegisterContactInformationViewController.eMail.getText());

            InputValidation.checkNumber(RegisterContactInformationViewController.phoneNumber.getText());
            sub.setPhoneNumber(RegisterContactInformationViewController.eMail.getText());

            InputValidation.checkAddress(RegisterContactInformationViewController.address.getText());
            sub.setAddress(RegisterContactInformationViewController.eMail.getText());

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


        int subID = ReadFromCSV.createID("data/substitute");
        int educationID = ReadFromCSV.createID("data/education");
        int referenceID = ReadFromCSV.createID("data/workReference");
        int workExperienceID = ReadFromCSV.createID("data/workExperience");

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
        reference.forEach(System.out::println);
        edu.forEach(System.out::println);
        wor.forEach(System.out::println);
    }
}


