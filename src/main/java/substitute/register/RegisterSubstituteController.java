package substitute.register;

import employer.Industry;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import readfromfile.ReadFromCSV;
import savetofile.SaveToCSV;
import substitute.register.education.Education;
import substitute.register.education.RegisterEducationController;
import substitute.register.references.RegisterWorkReferenceController;
import substitute.register.references.WorkReference;
import substitute.register.work.RegisterWorkExperienceController;
import substitute.register.work.Work;
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

        int subID = ReadFromCSV.getID("data/substitute");
        sub.setID(subID);
        sub.setEducation(RegisterEducationViewController.educations);
        sub.setReferences(RegisterReferenceViewController.references);
        sub.setWorkExperience(RegisterWorkExperienceViewController.previousWorkTable);
        sub.setWorkField(RegisterContactInformationViewController.wantedField);

        int educationID = ReadFromCSV.getID("data/education");
        int referenceID = ReadFromCSV.getID("data/workReference");
        int workExperienceID = ReadFromCSV.getID("data/workExperience");

        for (Work w : sub.getWorkExperience()) {
            w.assignSubstitute(sub);
            w.setID(workExperienceID++);
        }

        for (Education e : sub.getEducation()) {
            e.assignSubstitute(sub);
            e.setID(educationID++);
        }

        for (WorkReference wr : sub.getReferences()) {
            wr.assignSubstitute(sub);
            wr.setID(referenceID++);
        }


        SaveToCSV save = new SaveToCSV();

        List<Substitute> data = new ArrayList<>();
        data.add(sub);
        save.SaveToFile("data/education", sub.getEducation());
        save.SaveToFile("data/workReference", sub.getReferences());
        save.SaveToFile("data/workExperience", sub.getWorkExperience());
        save.SaveToFile("data/substitute", data);
        System.out.println(sub.getID());
    }
}


