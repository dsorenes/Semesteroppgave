package registersubstitute;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Person;
import savetofile.SaveToCSV;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterSubstituteController implements Initializable {

    @FXML
    TextField firstName;

    @FXML
    TextField lastName;

    @FXML
    Button register;

    @FXML
    TextField phoneNumber;

    @FXML
    DatePicker dateOfBirth;

    @FXML
    TextField eMail;

    @FXML
    TextField address;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
