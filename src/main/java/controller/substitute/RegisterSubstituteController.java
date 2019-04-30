package controller.substitute;

import controller.substitute.RegisterContactInformationController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import controller.substitute.RegisterEducationController;
import controller.substitute.RegisterWorkReferenceController;
import controller.substitute.RegisterWorkExperienceController;
import model.data.substitute.register.Substitute;

import java.net.URL;
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
                RegisterContactInformationViewController.dateOfBirth.getValue(), RegisterWorkExperienceViewController.previousWorkTable, RegisterEducationViewController.educations, RegisterContactInformationViewController.salaryDemand.getText(),
                RegisterContactInformationViewController.wantedField, RegisterReferenceViewController.references);
        System.out.println(sub);
    }
}


