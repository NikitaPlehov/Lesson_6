import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest extends BaseTest{

    Calculator cal = new Calculator("CalcTest");

    //@Test(invocationCount = 3, invocationTimeOut = 1000)
    @Test(invocationCount = 6, threadPoolSize = 3)
    public void invocationTest() throws InterruptedException {
        Thread.sleep(250);
        Assert.assertEquals(cal.sum(2,3),5);
        Assert.assertEquals(cal.sub(5,5),0);
        Assert.assertEquals(cal.multi(5,5),25);
        Assert.assertEquals(cal.div(10,5),2);
    }

    @Test (enabled = false)
    public void testSum(){
        System.out.println("CalcTest -> testSum");
    }
    public void testSub(){
        System.out.println("CalcTest -> testSub");
    }
    public void testMulti(){System.out.println("CalcTest -> testMulti");}
    public void testDiv(){System.out.println("CalcTest -> testDiv");}
}
