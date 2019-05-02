package model.utils;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ListCell;

/*
This class is only used in ClearInput to make ComboBox objects clear their selection and re-display
their promptText when such behaviour is natural

Such behaviour did not happen with ComboBox.getSelectionModel().clearSelection();

 */

public class PromptButtonCell<T> extends ListCell<T> {

    public final StringProperty promptText = new SimpleStringProperty();

    public PromptButtonCell (String promptText) {
        this.promptText.addListener((observer, oldText, newText) -> {
            if (isEmpty() || getItem() == null) setText(newText);
        });
        setPromptText(promptText);
    }

    public StringProperty promptTextProperty() {
        return promptText;
    }

    public final String getPromptText() {
        return promptTextProperty().get();
    }

    public final void setPromptText(String promptText) {
        promptTextProperty().set(promptText);
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(getPromptText());
        } else {
            setText(item.toString());
        }
    }

}
