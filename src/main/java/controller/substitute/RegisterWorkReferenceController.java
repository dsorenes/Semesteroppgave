package controller.substitute;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.ClearInput;
import model.data.substitute.references.WorkReference;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterWorkReferenceController implements Initializable {

    @FXML
    private TextField referenceName;

    @FXML
    private TextField referencePhone;

    @FXML
    private TextField referenceEmail;

    @FXML
    private TextField referenceEmployer;

    @FXML
    public TableView<WorkReference> referenceTableView;

    @FXML
    private TableColumn<WorkReference, String> fullNameCol;

    @FXML
    private TableColumn<WorkReference, String> phoneNumberCol;

    @FXML
    private TableColumn<WorkReference, String> eMailCol;

    @FXML
    private TableColumn<WorkReference, String> employerCol;

    @FXML
    private Button addReference;

    public ObservableList<WorkReference> references = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeReferenceTableView();

        addReference.setOnAction(e -> onAddReference());
    }

    void initializeReferenceTableView() {
        employerCol.setCellValueFactory(new PropertyValueFactory<>("employerName"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        eMailCol.setCellValueFactory(new PropertyValueFactory<>("eMail"));
    }

    void onAddReference() {
        references.add(new WorkReference(referenceName.getText(), referencePhone.getText(), referenceEmail.getText(), referenceEmployer.getText()));
        referenceTableView.setItems(references);
        ClearInput.clearInputFields(referenceName, referenceEmail, referenceEmployer, referencePhone);
    }
}
