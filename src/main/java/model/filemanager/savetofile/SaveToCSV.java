package model.filemanager.savetofile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;


public class SaveToCSV implements WriteToFile {

    public <T> boolean SaveToFile(String fileName, List<T> list) {
        OpenOption[] options = new OpenOption[] {CREATE, APPEND};
        Path path = Paths.get(fileName.concat(".csv"));

        try (
                var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, options)
        ) {
            for (T o : list) {
                writer.write(o.toString());
                writer.newLine();
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
