package MannyCoTest.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

	int value = 0;
	int maxValue = 1;
			
			
	
	@Override
	public boolean retry(ITestResult result) {
		if(value<maxValue)
		{
			value++;
			return true;
		}
		
		return false;
	
	
	}

}