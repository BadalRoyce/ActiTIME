package generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot implements ITestListener
{
	public void onTestSkipped(ITestResult result)
	{
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		
		String name=result.getName();
		Date today=Calendar.getInstance().getTime();	
		String date=today.toString().replaceAll(":", "-");
		
		File destfile=new File("./skipscreenshot/" +name +date+ ".png");
		try {
				FileUtils.copyFile(srcfile, destfile);
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}