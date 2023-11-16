package TestCases;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Implementation extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {

		capture(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".png");
	}
	

	
}
