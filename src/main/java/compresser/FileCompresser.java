package compresser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

public class FileCompresser implements Compresser{
    @Override
    public void compress(String input, String output) {
        System.out.println("File compression started. Depending on the file size, it may take a while...");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(input);
            fileOutputStream = new FileOutputStream(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileOutputStream);
        int data;

        try {
            while ((data=fileInputStream.read())!=-1)
            {
                deflaterOutputStream.write(data);
            }
            fileInputStream.close();
            deflaterOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
