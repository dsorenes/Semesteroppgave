package utils;

import javafx.scene.control.*;

public class ClearInput {

    public static void clearInputFields(TextField... fields) {
        for (TextField i : fields) i.clear();
    }

    public static void clearDropdowns(ComboBox... dropdowns) {
        for (ComboBox c : dropdowns) {
            c.getSelectionModel().clearSelection();
            c.setButtonCell(new PromptButtonCell(c.getPromptText()));
        }
    }

    public static void clearLists(ListView... lists) {
        for (ListView l : lists) l.getItems().clear();
    }

    public static void clearTables(TableView... tables) {
        for (TableView t : tables) t.getItems().clear();
    }

    public static void clearTextArea (TextArea... areas) {
        for (TextArea i : areas) i.clear();
    }

    public static void clearListSelection(ListView... lists) {
        for (ListView l : lists) l.getSelectionModel().clearSelection();
    }

}
