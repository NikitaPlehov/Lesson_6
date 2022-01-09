import org.testng.annotations.Test;

import java.util.List;

public class TimeOutTest {

    @Test(timeOut = 2000)
    public void timeOutTest() throws InterruptedException {
        Thread.sleep(999);

    }
}
