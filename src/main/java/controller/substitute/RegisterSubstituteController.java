package controller.substitute;

import javafx.event.ActionEvent;
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

    public Substitute substitute = new Substitute();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Substitute getSubstitute() {
        return this.substitute;
    }
}


