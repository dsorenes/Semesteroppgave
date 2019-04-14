package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button registerSubstitute;

    public void initialize() throws IOException {
    }

    @FXML
    private void loadRegisterSubstitute(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/registersubstitute/RegisterSubstituteView.fxml"));
        mainPane.getChildren().setAll(pane);
    }
}
