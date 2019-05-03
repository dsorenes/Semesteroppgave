package controller.employer;

import javafx.scene.control.Alert;
import model.data.employer.Industry;
import model.data.employer.Sector;
import model.data.employer.Employer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.exceptions.InvalidAddressException;
import model.exceptions.InvalidEmailException;
import model.exceptions.InvalidNameException;
import model.exceptions.InvalidNumberException;
import model.filemanager.readfromfile.CSVReader;
import model.filemanager.savetofile.CSVWriter;
import model.utils.ClearInput;
import model.utils.ErrorPopup;
import model.utils.InputValidation;

import java.io.IOException;
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

    void populateDropdowns() {
        industryDropdown.getItems().setAll(Industry.values());
        sectorDropdown.getItems().setAll(Sector.values());
    }

    private void onRegister() {

        Employer employer = new Employer();
        ArrayList<Employer> employees = new ArrayList<>();
        int employerID = 1;

        try {

            InputValidation.checkName(companyName.getText());
            employer.setCompanyName(companyName.getText());

            InputValidation.checkAddress(companyAddress.getText());
            employer.setCompanyAddress(companyAddress.getText());

            InputValidation.checkName(firstName.getText());
            employer.setFirstName(firstName.getText());

            InputValidation.checkName(lastName.getText());
            employer.setLastName(lastName.getText());

            InputValidation.checkNumber(phoneNumber.getText());
            employer.setPhoneNumber(phoneNumber.getText());

            InputValidation.checkEmail(eMail.getText());
            employer.setEMail(eMail.getText());

            employer.setIndustry(industryDropdown.getValue());
            employer.setSector(sectorDropdown.getValue());

            employerID = CSVReader.createIdCSV("data/employer/employer");

            employer.setID(employerID);
            employees.add(employer);
            CSVWriter save = new CSVWriter();
            save.SaveToFile("data/employer/employer", employees);

            ClearInput.clearInputFields(firstName, lastName, phoneNumber, companyName, companyAddress, eMail);
            ClearInput.clearDropdowns(industryDropdown, sectorDropdown);
        } catch (InvalidNameException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid name", "Invalid name");
        } catch (InvalidNumberException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid number", "Invalid number");
        } catch (InvalidEmailException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid Email", "Invalid Email");
        } catch (InvalidAddressException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ErrorPopup.createAlert(Alert.AlertType.ERROR,"Invalid Address", "Invalid Address");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateDropdowns();

        register.setOnAction(e -> onRegister());

    }

}
