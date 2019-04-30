package model.filemanager.oldwritereader.savetofile;

import java.util.List;

public interface WriteToFile {

     <T> boolean SaveToFile(String fileName, List<T> list);
}