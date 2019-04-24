package substitute.register;

import employer.Industry;
import employer.Sector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import savetofile.SaveToCSV;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
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

    @FXML
    ComboBox<Industry> industryDropdown;

    @FXML
    ComboBox<Sector> sectorDropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        List<Substitute> list = new ArrayList<>();
//        SaveToCSV save = new SaveToCSV();
//        //Should this logic be moved somewhere else to adhere to the MVC pattern?
//        register.setOnAction(e -> {
//            list.add(new Substitute(firstName.getText(), lastName.getText(), eMail.getText(), address.getText(), phoneNumber.getText(), dateOfBirth.getValue()));
//
//            if (!list.isEmpty()) {
//                list.forEach((n) -> System.out.println(n.toString()));
//                if (save.SaveToFile("substitute", list)) {
//                    System.out.println("saved!");
//                }
//            }
//
//        });

    }

}
