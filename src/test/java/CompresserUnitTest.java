import compresser.Compresser;
import compresser.FileCompresser;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.StringConstants;

import java.io.File;

public class CompresserUnitTest {
    private static Compresser compresser;

    @BeforeClass
    public static void initializeObjects(){
        compresser = new FileCompresser();
    }

    @Test
    public void testCompresser(){
        compresser.compress(StringConstants.TEST_PHOTO_PATH, StringConstants.OUTPUT_PHOTO_PATH);
        Assert.assertTrue(new File(StringConstants.OUTPUT_PHOTO_PATH).exists());
        Assert.assertEquals(10598400, new File(StringConstants.OUTPUT_PHOTO_PATH).length(), 0.0);
    }
    
    @AfterClass
    public static void closeObjects(){
        File output = new File(StringConstants.OUTPUT_PHOTO_PATH);
        output.delete();
    }
}
