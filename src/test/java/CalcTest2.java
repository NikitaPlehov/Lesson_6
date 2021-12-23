import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest2 extends BaseTest {
    private Calculator calc = new Calculator("CalcTest2");

    @Test(description = "Test of Sub in my Calculator",
            groups = "smoke")
    public void testSub() {
        System.out.println("CalcTest2 -> testSub");
    }

    @Test
    public void testSub1() {
        System.out.println("CalcTest2 -> testSub1");
    }

    @Test(dataProvider = "dataForSub", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.sub(a, b), expectedResult);
    }
}
