package readfromfile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

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
        String line;
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)
        ) {
            while ((line = reader.readLine()) != null) {
                ID++;
            }

            return ID;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

     public ArrayList<String> findAttributes(String filename, int id) {
        Path path = Paths.get(filename.concat(".csv"));
        String line;
        String ID = Integer.toString(id);

        ArrayList<String> matches = new ArrayList<>();
        try (
                var reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                ) {

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > 0) {
                    String substituteID = data[1];
                    if (substituteID.compareTo(ID) == 0) {
                        matches.add(line);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (matches.isEmpty()) {
            return null;
        }

        return matches;
    }

}
