package controller.substitute;

import javafx.scene.Parent;
import model.data.employer.Industry;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import model.data.substitute.Substitute;
import model.exceptions.InvalidAddressException;
import model.exceptions.InvalidEmailException;
import model.exceptions.InvalidNameException;
import model.exceptions.InvalidNumberException;
import model.utils.ClearInput;
import model.utils.ErrorPopup;
import model.utils.InputValidation;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;


public class RegisterContactInformationController implements Initializable {

    @FXML
    protected TextField firstName;

    @FXML
    protected TextField lastName;

    @FXML
    protected TextField phoneNumber;

    @FXML
    protected DatePicker dateOfBirth;

    @FXML
    protected TextField eMail;

    @FXML
    protected TextField address;

    @FXML
    private ComboBox<Industry> industryDropdown;

    @FXML
    public ListView<Industry> industryListView;

    @FXML
    private Button addWantedIndustry;

    @FXML
    protected TextArea salaryDemand;

    protected ObservableList<Industry> wantedField = FXCollections.observableArrayList();

    public Substitute substitute = new Substitute();
    public Substitute getSubstitute() { return this.substitute; }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIndustryDropdown();
        addWantedIndustry.setOnAction(e-> onAddWantedIndustry());
    }

    void initializeIndustryDropdown() {
        industryDropdown.getItems().setAll(Industry.values());
    }

    void onAddWantedIndustry() {
       wantedField.add(industryDropdown.getValue());
       industryListView.setItems(wantedField);

        ClearInput.clearDropdowns(industryDropdown);
    }

    @FXML
    private AnchorPane rootPane;

    @FXML
    private void NextPage(ActionEvent event) {

        try {
            InputValidation.checkName(firstName.getText());
            substitute.setFirstName(firstName.getText());

            InputValidation.checkName(lastName.getText());
            substitute.setLastName(lastName.getText());

            substitute.setDateOfBirth(dateOfBirth.getValue());

            InputValidation.checkAddress(address.getText());
            substitute.setAddress(address.getText());

            InputValidation.checkNumber(phoneNumber.getText());
            substitute.setPhoneNumber(phoneNumber.getText());

            InputValidation.checkEmail(eMail.getText());
            substitute.setEMail(eMail.getText());

            substitute.setWantedWorkFields(wantedField);

            System.out.println(substitute);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substitute/education/RegisterEducationView.fxml"));
            Parent pane = loader.load();
            rootPane.getChildren().setAll(pane);

            RegisterEducationController controller = loader.getController();
            controller.setSubstitute(this.substitute);



        } catch (IOException e) { e.printStackTrace();
            e.printStackTrace();
            System.out.println(e.getMessage());
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

}
