package decompresser;

import compresser.FileCompresser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RecursiveDecompresser implements Decompresser {
    private FileDecompresser fileDecompresser;
    @Override
    public void decompress(String input, String output) {
        fileDecompresser = new FileDecompresser();
        System.out.println("Recursive decompression started. This may take a while...");
        try {
            Files.walk(Paths.get(input))
                    .filter(Files::isRegularFile)
                    .forEach(file -> fileDecompresser.decompress(file.toFile().getAbsolutePath(), output + file.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
