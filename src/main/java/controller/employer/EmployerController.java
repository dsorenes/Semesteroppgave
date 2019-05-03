package controller.employer;

import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.employer.Employer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.filemanager.readfromfile.CSVReader;
import model.filemanager.savetofile.CSVWriter;
import model.utils.ClearInput;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployerController implements Initializable {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField companyName;

    @FXML
    private TextField companyAddress;

    @FXML
    private TextField eMail;

    @FXML
    private Button register;

    @FXML
    private ComboBox<Industry> industryDropdown;

    @FXML
    private ComboBox<Sector> sectorDropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateDropdowns();

        register.setOnAction(e -> onRegister());

    }

    void populateDropdowns() {
        industryDropdown.getItems().setAll(Industry.values());
        sectorDropdown.getItems().setAll(Sector.values());
    }

    private void onRegister() {
        Employer employer = new Employer(companyName.getText(), companyAddress.getText(), firstName.getText(), lastName.getText(), phoneNumber.getText(), eMail.getText(), industryDropdown.getValue(), sectorDropdown.getValue());
        ArrayList<Employer> employees = new ArrayList<>();
        int employerID = 1;
        employerID = CSVReader.createIdCSV("data/employer/employer");

        employer.setID(employerID);
        employees.add(employer);
        CSVWriter save = new CSVWriter();
        save.SaveToFile("data/employer/employer", employees);


        ClearInput.clearInputFields(firstName, lastName, phoneNumber, companyName, companyAddress, eMail);
        ClearInput.clearDropdowns(industryDropdown, sectorDropdown);

    }
}
