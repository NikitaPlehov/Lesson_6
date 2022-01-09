import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSum {
    private Calculator calc = new Calculator("CalcTest1");

    @Test(description = "Test of Sum in my Calculator", priority = 3, groups = "smoke")
    public void testSum(){Assert.assertEquals(calc.sum(10, 3), 13);}

    @Test(priority = 2, groups = "smoke")
    public void testSum1(){
        Assert.assertEquals(calc.sum(10, 6), 16);
    }

    @Test(priority = 1, groups = "smoke")
    public void testSum2(){
        Assert.assertEquals(calc.sum(18, 6), 24);
    }
}


