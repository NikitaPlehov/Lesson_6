import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest4 extends BaseTest {
    private Calculator calc = new Calculator("CalcTest4");

    @Test(description = "Test of Div in my Calculator",
            groups = "smoke")
    public void testDiv() {
        System.out.println("CalcTest4 -> testDiv");
    }

    @Test
    public void testDiv1() {
        System.out.println("CalcTest4 -> testDiv1");
    }

    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(double a, double b, double expectedResult) {
        Assert.assertEquals(calc.div(a, b), expectedResult);
    }
}
