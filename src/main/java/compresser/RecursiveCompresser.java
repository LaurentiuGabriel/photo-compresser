package compresser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utils.HelperFunctions.createFolder;
import static utils.HelperFunctions.getFileNameWithoutExtension;

public class RecursiveCompresser implements Compresser{
    private FileCompresser fileCompresser;
    @Override
    public void compress(String input, String output) {
        fileCompresser = new FileCompresser();
        createFolder(output);
        System.out.println("Recursive compression started. This may take a while...");
        try {
            Files.walk(Paths.get(input))
                    .filter(Files::isRegularFile)
                    .forEach(file -> fileCompresser.compress(file.toFile().getAbsolutePath(), output + "/" + getFileNameWithoutExtension(file.getFileName().toString())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
