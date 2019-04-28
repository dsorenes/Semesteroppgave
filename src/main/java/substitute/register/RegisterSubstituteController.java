package substitute.register;

import employer.Industry;
import employer.Sector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import savetofile.SaveToCSV;
import substitute.register.education.RegisterEducationController;
import substitute.register.work.RegisterWorkExperienceController;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void onRegister() {
        Substitute sub = new Substitute(RegisterContactInformationViewController.firstName.getText(), RegisterContactInformationViewController.lastName.getText(),
                RegisterContactInformationViewController.eMail.getText(), RegisterContactInformationViewController.address.getText(), RegisterContactInformationViewController.phoneNumber.getText(),
                RegisterContactInformationViewController.dateOfBirth.getValue(), RegisterWorkExperienceViewController.previousWorkTable, RegisterEducationViewController.educations, RegisterContactInformationViewController.salaryDemand.getText(),
                RegisterContactInformationViewController.wantedField);
        System.out.println(sub);
    }
}


