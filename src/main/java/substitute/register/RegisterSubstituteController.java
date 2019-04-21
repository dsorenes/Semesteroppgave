package substitute.register;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
        List<Substitute> list = new ArrayList<>();
        SaveToCSV save = new SaveToCSV();
        register.setOnAction(e -> {
            list.add(new Substitute(firstName.getText(), lastName.getText(), eMail.getText(), address.getText(), phoneNumber.getText(), dateOfBirth.getValue()));

            if (!list.isEmpty()) {
                list.forEach((n) -> System.out.println(n.toString()));
                if (save.SaveToFile("substitute", list)) {
                    System.out.println("saved!");
                }
            }

        });

    }

}
