package decompresser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.InflaterOutputStream;

public class FileDecompresser implements Decompresser{
    @Override
    public void decompress(String input, String output) {
        System.out.println("File decompression started. Depending on the file size, it may take a while...");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(input);
            fileOutputStream = new FileOutputStream(output);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(fileOutputStream);
        int data;

        try {
            while ((data=fileInputStream.read())!=-1)
            {
                inflaterOutputStream.write(data);
            }
            fileInputStream.close();
            inflaterOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
