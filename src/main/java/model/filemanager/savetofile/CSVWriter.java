package model.filemanager.savetofile;

import model.filemanager.readfromfile.CSVReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;


public class CSVWriter implements FileWriter {

    private static final Charset encoding = StandardCharsets.ISO_8859_1;
    private static final OpenOption[] options = new OpenOption[] {CREATE, APPEND};

    public <T> boolean SaveToFile(String fileName, List<T> list) {

        Path path = Paths.get(fileName.concat(".csv"));

        try (var writer = Files.newBufferedWriter(path, encoding, options)) {
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

    public static boolean editLine(String fileName, int id, String old, String replacement) {
        String lineFromFile = CSVReader.findLine(fileName, id);
        Path path = Paths.get(fileName.concat(".csv"));
        if (lineFromFile == null || !lineFromFile.contains(old)) return false;

        String newLine = lineFromFile.replace(old, replacement);
        CSVReader read = new CSVReader();
        ArrayList<String> oldFile = read.ReadFromFile(fileName);

        try (var writer = Files.newBufferedWriter(path, encoding, StandardOpenOption.TRUNCATE_EXISTING)) {
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
