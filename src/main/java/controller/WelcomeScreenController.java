package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {

    @FXML
    private Button LoggInn;


    public void initialize() {
        LoggInn.setOnAction(e -> {
            try {

                MainView();

                Stage stage = (Stage) LoggInn.getScene().getWindow();
                stage.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        });
    }

    private void MainView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Vikarbyrå AS");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
