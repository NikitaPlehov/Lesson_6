import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class CalcDiv {
    private Calculator calc = new Calculator("CalcDiv");

    @Test(groups = "smoke")
    public void testDiv() {
        Assert.assertEquals(calc.div(10,5),2);
    }

    @Test
    public void testDiv1() {
        Assert.assertEquals(calc.div(9, 1), 9);
    }

    @Test (timeOut = 1000, expectedExceptions = ThreadTimeoutException.class)
    public void testDiv2() throws InterruptedException {
        Assert.assertEquals(calc.div(15, 5), 3);
        Thread.sleep(2000);
    }

    @Test
    public void divTest1() {
        Assert.assertEquals(calc.div(6, 2), 3);
    }

    public int a = 36;
    public int b = 10;

    @Test(expectedExceptions = ArithmeticException.class)
    public void divTest2() {
        System.out.println("a / b = " + (a / 0));
    }
}


