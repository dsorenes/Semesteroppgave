package input;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Person;
import savetofile.SaveToCSV;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InputController implements Initializable {

    @FXML
    TextField firstname;

    @FXML
    TextField lastname;

    @FXML
    Button submit;

    @FXML
    Button save;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        SaveToCSV saveCSV = new SaveToCSV();
        submit.setOnAction(e -> list.add(new Person(firstname.getText(), lastname.getText())));


       save.setOnAction(e -> saveCSV.SaveToFile("person.csv", list));
    }
}
