package MannyCoTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MannyCoTest.abstractOps.abstractOpers;


public class innerFunctions extends abstractOpers{
   
	/*Keep in mind the point of this and all the drivers on the page
	  is to link the drivers form the child page to this the parent page*/
	WebDriver driver;
	public innerFunctions(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*We're finding elements on the page by
	   using a tool called PAGE FACTORY*/
	 
	
	@FindBy(id="userEmail") 
	WebElement userEmail;
	
	@FindBy(id="userPassword") 
	WebElement userPass;
	
	@FindBy(id="login") 
	WebElement loginBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public productsOnPage loginIn(String userName, String userPassword)
	{
		userEmail.sendKeys(userName);
		userPass.sendKeys(userPassword);
		loginBtn.click();
		productsOnPage productsPage = new productsOnPage(driver);
		return productsPage;
		
	}
	
	public String getErrorMsg()
	{
		waitForWebElem(errorMessage);
		return errorMessage.getText();
	}
	
	public void launchWeb()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
   }

