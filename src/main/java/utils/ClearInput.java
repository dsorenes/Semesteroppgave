package utils;

import javafx.event.EventType;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClearInput {

    public static void clearInputFields(TextField... fields) {
        for (TextField i : fields) {
            i.clear();
        }
    }

    public static void clearDropdowns(ComboBox... dropdowns) {
        List<String> prompts = new ArrayList<>();

        for (ComboBox c : dropdowns) {
            prompts.add(c.getPromptText());
            c.getSelectionModel().clearSelection();
            c.setPromptText(null);

        }

        int i = 0;
        for (ComboBox c : dropdowns) {
            c.setPromptText(prompts.get(i));
            c.setEditable(false);
            i++;
        }
    }

    public static void clearLists(ListView... lists) {
        for (ListView l : lists) {
            l.getItems().clear();
        }
    }

    public static void clearTables(TableView... tables) {
        for (TableView t : tables) {
            t.getItems().clear();
        }
    }

}
