package substitute.register;

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
                RegisterContactInformationViewController.dateOfBirth.getValue(), RegisterWorkExperienceViewController.previousWorkTable, RegisterEducationViewController.educations, RegisterContactInformationViewController.salaryDemand.getText(),
                RegisterContactInformationViewController.wantedField, RegisterReferenceViewController.references);


        int id = ReadFromCSV.getID("data/substitute");
        sub.setID(id);

        SaveToCSV save = new SaveToCSV();

        List<Substitute> data = new ArrayList<>();
        data.add(sub);


        save.SaveToFile("data/substitute", data);
        System.out.println(sub.getID());
    }
}


