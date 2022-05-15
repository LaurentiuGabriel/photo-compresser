package utils;

import java.io.File;

public class HelperFunctions {
    public static void createFolder(String path){
        new File(path).mkdirs();
    }

    public static String getFileNameWithoutExtension(String file) {
        String fileName = "";
        fileName = file.replaceFirst("[.][^.]+$", "");

        return fileName;
    }
}
