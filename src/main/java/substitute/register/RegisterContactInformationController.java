package substitute.register;

import employer.Industry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import utils.ClearInput;

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
}
