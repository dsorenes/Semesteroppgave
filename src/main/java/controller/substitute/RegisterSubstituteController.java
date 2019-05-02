package controller.substitute;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.data.substitute.Substitute;

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

    public Substitute substitute = new Substitute();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Substitute getSubstitute() {
        return this.substitute;
    }
}


