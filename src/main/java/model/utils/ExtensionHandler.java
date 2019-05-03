package model.utils;

import model.exceptions.InvalidFileTypeException;

import java.io.File;

public class ExtensionHandler {


    public static String getExtension(File file) throws InvalidFileTypeException {

        String[] ext = file.getName().split("\\.");

        if (ext.length < 2) {
            throw new InvalidFileTypeException("Invalid file type. Must be .jobj or .csv");
        }

        String extension = "."+ext[ext.length - 1];

        if (!(extension.equals(".jobj") ^ extension.equals(".csv"))) {
            throw new InvalidFileTypeException("Invalid file type. Must be .jobj or .csv");
        }

        return extension;
    }
}
