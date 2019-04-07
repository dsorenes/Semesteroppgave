package savetofile;

import person.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SaveToJOBJ extends WriteToFile {

    @Override
    public void SaveToFile(String path, List<Person> list) {
        try (
                var writer = new PrintWriter(path, "UTF-8")
                ) {

            for (Object o : list) {
                writer.println(o);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
