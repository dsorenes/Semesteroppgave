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

        ArrayList<String> reference = new ArrayList<>(read.findAttributes("data/workReference", 1));
        ArrayList<String> edu = new ArrayList<>(read.findAttributes("data/education", 1));
        ArrayList<String> wor = new ArrayList<>(read.findAttributes("data/workExperience", 1));
        reference.forEach(System.out::println);
        edu.forEach(System.out::println);
        wor.forEach(System.out::println);
    }
}


