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
import utils.ClearInput;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
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

            substitute.setFirstName(firstName.getText());
            substitute.setLastName(lastName.getText());
            substitute.setDateOfBirth(dateOfBirth.getValue());
            substitute.setAddress(address.getText());
            substitute.setPhoneNumber(phoneNumber.getText());
            substitute.setEMail(eMail.getText());
            substitute.setWantedWorkFields(wantedField);

            System.out.println(substitute);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/register/substitute/education/RegisterEducationView.fxml"));
            Parent pane = loader.load();
            rootPane.getChildren().setAll(pane);

            RegisterEducationController controller = loader.getController();
            controller.setSubstitute(this.substitute);



        } catch (IOException e) { e.printStackTrace();

        }


    }

    public Substitute getSubstitute() {
        return this.substitute;
    }


}
