package input;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import person.Person;
import savetofile.SaveToJOBJ;

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
        SaveToJOBJ stj = new SaveToJOBJ();
        submit.setOnAction(e -> list.add(new Person(firstname.getText(), lastname.getText())));


       save.setOnAction(e -> stj.SaveToFile("C:\\Users\\Daniel\\OneDrive - OsloMet\\Programutvikling\\Semesteroppgave\\person.txt", list));
    }
}
