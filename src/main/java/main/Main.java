package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage stage;

    public Stage getStage() {
        return this.stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("Welcome");
        this.stage.setResizable(false);
        this.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/WelcomeScreen.fxml"))));
        this.stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
