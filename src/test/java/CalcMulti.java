import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcMulti {

    private Calculator calc = new Calculator("CalcMulti");

    @Test(invocationCount = 6, threadPoolSize = 3)
    public void invocationTest() throws InterruptedException {
        Assert.assertEquals(calc.multi(5, 5), 25);
    }

    @Test(dataProvider = "dataForMulti", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedResult) {
        Assert.assertEquals(calc.multi(a, b), expectedResult);
    }

    int a = 25;
    int b = 1;
    int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void testMulti() {
        if (calc.multi(a,b) == 25) {
            Assert.assertTrue(true);
        } else {
            System.out.println("attempt_" + attempt);
            attempt++;
            b++;
            throw new NullPointerException();
        }
    }
}