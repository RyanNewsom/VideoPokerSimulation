import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Ryan on 12/5/2015.
 */
public class VPDriverTest extends TestCase {

    @Test
    public void testHand(){
        String payTableString = "250 50 25 7 5 4 3 2 1 0";
        VPDriver driver = new VPDriver(payTableString);
        driver.testHand(0, 13, 27, 28, 29);
    }

}