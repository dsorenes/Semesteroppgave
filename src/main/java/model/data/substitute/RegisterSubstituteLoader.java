package model.data.substitute;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegisterSubstituteLoader extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("RegisterSubstituteView.fxml"))));
        stage.setTitle("Register substitute");
        stage.show();

    }

}
