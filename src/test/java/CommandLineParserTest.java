import com.github.stefanbirkner.systemlambda.SystemLambda;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.CommandLineParser;
import utils.StringConstants;

public class CommandLineParserTest {
    private static CommandLineParser commandLineParser;
    private static String[] validOpts = {"--strategy", "file", "--action", "compress", "--input",  StringConstants.TEST_PHOTO_PATH, "--output", StringConstants.OUTPUT_PHOTO_PATH};
    private static String[] invalidOpts = {"--strategy", "unknown", "--action", "unknown", "--input",  StringConstants.TEST_PHOTO_PATH, "--output", StringConstants.OUTPUT_PHOTO_PATH};


    @BeforeClass
    public static void initializeObjects(){
        commandLineParser = new CommandLineParser();
    }

    @Test
    public void testValidOpts(){
        commandLineParser.parseCliArgs(validOpts);
        Assert.assertEquals(commandLineParser.getAction(), "compress");
        Assert.assertEquals(commandLineParser.getStrategy(), "file");
        Assert.assertEquals(commandLineParser.getInput(), StringConstants.TEST_PHOTO_PATH);
        Assert.assertEquals(commandLineParser.getOutput(), StringConstants.OUTPUT_PHOTO_PATH);
    }

    @SneakyThrows
    @Test
    public void testInvalidOpts(){
        int status = SystemLambda.catchSystemExit(() -> {
            commandLineParser.parseCliArgs(invalidOpts);
        });

        Assert.assertEquals(1, status);
    }
}
