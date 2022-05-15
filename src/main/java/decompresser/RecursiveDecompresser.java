package decompresser;

import compresser.FileCompresser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utils.HelperFunctions.createFolder;
import static utils.HelperFunctions.getFileNameWithoutExtension;

public class RecursiveDecompresser implements Decompresser {
    private FileDecompresser fileDecompresser;
    @Override
    public void decompress(String input, String output) {
        fileDecompresser = new FileDecompresser();
        createFolder(output);
        System.out.println("Recursive decompression started. This may take a while...");
        try {
            Files.walk(Paths.get(input))
                    .filter(Files::isRegularFile)
                    .forEach(file -> fileDecompresser.decompress(file.toFile().getAbsolutePath(), output + "/" + getFileNameWithoutExtension(file.getFileName().toString())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
