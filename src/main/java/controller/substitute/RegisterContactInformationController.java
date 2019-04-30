package controller.substitute;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.data.employer.Industry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    private ListView<Industry> industryListView;

    @FXML
    private Button addWantedIndustry;

    @FXML
    private Button nextPage;

    @FXML
    protected TextArea salaryDemand;

    protected ObservableList<Industry> wantedField = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeIndustryDropdown();
        addWantedIndustry.setOnAction(e -> onAddWantedIndustry());
    }

    void initializeIndustryDropdown() {
        industryDropdown.getItems().setAll(Industry.values());
    }

    void onAddWantedIndustry() {
        wantedField.add(industryDropdown.getValue());
        industryListView.setItems(wantedField);
    }

    @FXML
    private AnchorPane rootPane;


    @FXML
    private void NextPage(ActionEvent event) {
        try {

            AnchorPane pane =FXMLLoader.load(getClass().getResource("/view/substitute/RegisterEducationView.fxml"));
            rootPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*
    public void initialize() {

        nextPage.setOnAction(e -> {

        });

    }
*/
}
