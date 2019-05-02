package model.filemanager.savetofile;

import java.util.List;

public interface FileWriter {

     boolean WriteToFile(String fileName, List<?> list);
}