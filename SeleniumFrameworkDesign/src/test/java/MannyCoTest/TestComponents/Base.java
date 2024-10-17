package MannyCoTest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MannyCoTest.pageobjects.innerFunctions;

public class Base {
	
	public WebDriver driver;
	public innerFunctions inFunctions;
	public WebDriver initDriver() throws IOException
	{
		Properties prop  = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/MannyCoTest/resources/GlobalData.properties");
		prop.load(fis);
		String browseName = System.getProperty("browser")!=null ? System.getProperty("browser")  :prop.getProperty("browser");
		
		if(browseName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(browseName.contains("headless")) {
				options.addArguments("headless");	
			}
			
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,990));
		}
		
		
		
		
		
		else if(browseName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browseName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;

	}
	
	
	
	
	public List<HashMap<String, String>> jsonToMap(String filePath) throws IOException
	{
		
		//This is reading the created data json file to string
	String jsonFile =	FileUtils.readFileToString(new File (filePath)
			,StandardCharsets.UTF_8);
		
	ObjectMapper mapper = new ObjectMapper();	
	
	List<HashMap<String, String>> data = mapper.readValue(jsonFile, new TypeReference <List<HashMap<String, String>>>(){
		
	});
	return data;
	
	}
	
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"ssResults"+ testCaseName +".png");
		FileUtils.copyFile(source, file );
		return System.getProperty("user.dir")+"ssResults"+ testCaseName +".png";
		
		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public innerFunctions launchApp() throws IOException
	{
		 driver = initDriver();
		inFunctions = new innerFunctions(driver);
		inFunctions.launchWeb();
		return inFunctions;

		
	}
	
	@AfterMethod(alwaysRun=true)
	public void exit()
	{
		driver.close();
	}
	

}
