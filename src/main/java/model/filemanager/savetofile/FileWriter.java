package model.filemanager.savetofile;

import java.util.List;

interface FileWriter {
     <T> boolean SaveToFile(String fileName, List<T> list);
}