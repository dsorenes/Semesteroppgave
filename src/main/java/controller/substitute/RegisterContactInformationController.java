package controller.substitute;

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

        Substitute sub = new Substitute();

        try {

            sub.setFirstName(firstName.getText());
            sub.setLastName(lastName.getText());
            sub.setDateOfBirth(dateOfBirth.getValue());
            sub.setAddress(address.getText());
            sub.setPhoneNumber(phoneNumber.getText());
            sub.setEMail(eMail.getText());

            setData(sub);

            AnchorPane pane =FXMLLoader.load(getClass().getResource("/view/register/substitute/education/RegisterEducationView.fxml"));
            rootPane.getChildren().setAll(pane);


        } catch (IOException e) { e.printStackTrace();

        }


    }

    public void setData(Substitute subContactInfo) {

        subContactInfo.setFirstName(firstName.getText());
        subContactInfo.setLastName(lastName.getText());
        subContactInfo.setDateOfBirth(dateOfBirth.getValue());
        subContactInfo.setAddress(address.getText());
        subContactInfo.setPhoneNumber(phoneNumber.getText());
        subContactInfo.setEMail(eMail.getText());

    }


}
