package savetofile;

import model.Person;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class WriteToFile {

     public <T> void SaveToFile (String fileName, List<T> list) {
         Path path = Paths.get(fileName);
          try (
                  var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)
                  ) {
             for (T o : list) {
                  writer.write(o.toString());
                  writer.newLine();
             }

          } catch (IOException e) {
               e.printStackTrace();
          }
     }
}
