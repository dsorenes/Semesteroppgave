package savetofile;

import model.Person;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.APPEND;


public class SaveToCSV extends WriteToFile {

    @Override
    public void SaveToFile(String fileName, List<Person> list) {
        OpenOption[] options = new OpenOption[] {CREATE, APPEND};
        Path path = Paths.get(fileName);

        try (
                var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, options)
        ) {
            for (Person o : list) {
                writer.write(o.firstname + ";" + o.lastname);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
