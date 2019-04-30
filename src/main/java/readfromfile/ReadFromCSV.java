package readfromfile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFromCSV implements ReadFromFile {
    @Override
    public boolean ReadFromFile(String fileName) {
        Path path = Paths.get(fileName.concat(".csv"));
        String line;
        try (
            var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
            ) {

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static int createID(String filename) {
        Path path = Paths.get(filename.concat(".csv"));
        int ID = 0;
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
        ) {

            while (reader.readLine() != null) {
                ID++;
            }

            return ID;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
