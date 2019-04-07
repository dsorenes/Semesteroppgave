package input;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InputController implements Initializable {

    @FXML
    TextField firstname;

    @FXML
    TextField lastname;

    @FXML
    Button submit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submit.setOnAction(e -> System.out.println(firstname.getText() + ", " + lastname.getText()));
    }
}
