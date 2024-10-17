package MannyCoTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MannyCoTest.abstractOps.abstractOpers;

public class confirmationPage extends abstractOpers {

	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css=".hero-primary")
	WebElement confirmationMessage;
	
	By confMsg = By.cssSelector(".hero-primary");
	
	public String getConfirmationMsg()
	{
		waitForElem(confMsg);
		return confirmationMessage.getText();
	}
	

	
	
}
