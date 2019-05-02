package model.filemanager.savetofile;

import model.filemanager.readfromfile.ReadFromCSV;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;


public class SaveToCSV implements WriteToFile {

    private OpenOption[] options = new OpenOption[] {CREATE, APPEND};

    public <T> boolean SaveToFile(String fileName, List<T> list) {

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

    public boolean editLine(String fileName, int id, String old, String replacement) {
        String lineFromFile = ReadFromCSV.findLine(fileName, id);
        Path path = Paths.get(fileName.concat(".csv"));
        if (lineFromFile == null) return false;

        String newLine = lineFromFile.replace(old, replacement);
        ReadFromCSV read = new ReadFromCSV();
        ArrayList<String> oldFile = read.ReadFromFile(fileName);

        try (
                var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING)
                ) {
            for (String i : oldFile) {
                if (i.equals(lineFromFile)) {
                    writer.write(newLine);
                    writer.newLine();
                } else {
                    writer.write(i);
                    writer.newLine();
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
