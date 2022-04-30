import compresser.FileCompresser;
import compresser.RecursiveCompresser;
import decompresser.FileDecompresser;
import decompresser.RecursiveDecompresser;
import utils.Action;
import utils.CommandLineParser;
import utils.Strategy;

public class Main {
    private static FileCompresser fileCompresser;
    private static RecursiveCompresser recursiveCompresser;
    private static FileDecompresser fileDecompresser;
    private static RecursiveDecompresser recursiveDecompresser;

    public static void main(String[] args) {
        CommandLineParser cli = new CommandLineParser();
        cli.parseCliArgs(args);

        if(cli.getAction().equalsIgnoreCase(Action.COMPRESS.toString())) {
            fileCompresser = new FileCompresser();
            recursiveCompresser = new RecursiveCompresser();
            if(cli.getStrategy().equalsIgnoreCase(Strategy.FILE.toString()))
                fileCompresser.compress(cli.getInput(), cli.getOutput());
            else
                recursiveCompresser.compress(cli.getInput(), cli.getOutput());
        }
        else {
            fileDecompresser = new FileDecompresser();
            recursiveDecompresser = new RecursiveDecompresser();
            if(cli.getStrategy().equalsIgnoreCase(Strategy.FILE.toString()))
                fileDecompresser.decompress(cli.getInput(), cli.getOutput());
            else
                recursiveDecompresser.decompress(cli.getInput(), cli.getOutput());
        }

        ;
    }
}
