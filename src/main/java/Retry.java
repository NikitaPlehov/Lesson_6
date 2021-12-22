import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

public class Retry implements IRetryAnalyzer {
    private int attempt = 1;
    private static final int MAX_RETRY = 5;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()){
            if (attempt < MAX_RETRY){
                attempt++;
                iTestResult.setStatus(TestResult.FAILURE);
                System.out.println("Retying one more time.");
                return true;
            }else {
                iTestResult.setStatus(TestResult.FAILURE);
            }
        }else {
            iTestResult.setStatus(TestResult.SUCCESS);
        }
        return false;
    }
}
