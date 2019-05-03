package utils;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;

public class FileGrabber {


    public static File getFile() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter jobj = new FileChooser.ExtensionFilter("jobj files (*.jobj)", "*.jobj");
        FileChooser.ExtensionFilter csv = new FileChooser.ExtensionFilter("csv files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(jobj);
        fileChooser.getExtensionFilters().add(csv);

        return fileChooser.showOpenDialog(null);
    }

}
