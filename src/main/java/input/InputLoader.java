package input;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InputLoader extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("InputView.fxml"))));
        stage.setTitle("Hello from InputLoader");
        stage.show();

    }

    public static void main (String[] args) {
        launch(args);
    }
}
