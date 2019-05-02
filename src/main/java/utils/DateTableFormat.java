package utils;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import model.data.substitute.work.Work;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTableFormat {

    public static void setFormatTo(TableColumn<Work, LocalDate>... columns) {
        for (TableColumn<Work, LocalDate> c : columns) {
            c.setCellFactory((TableColumn<Work, LocalDate> column) -> new TableCell<>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    }
                }
            });
        }


    }
}
