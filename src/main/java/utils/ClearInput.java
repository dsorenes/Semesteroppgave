package utils;

import javafx.event.EventType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ClearInput {

    public static void clearInputFields(TextField... fields) {
        for (TextField i : fields) {
            i.clear();
        }
    }

}
