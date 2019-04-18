package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    public AnchorPane mainPane;

    @FXML
    private Button registerSubstitute;

    public void initialize() {
        registerSubstitute.setOnAction(e -> {
            try {
                loadRegisterSubstitute();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void loadRegisterSubstitute() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/registersubstitute/RegisterSubstituteView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Register Substitute");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
