package MannyCoTest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MannyCoTest.abstractOps.abstractOpers;

public class checkOutPage extends abstractOpers{

	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div/div/input[@placeholder='Select Country']")
	WebElement searchCountry;
	
	@FindBy(css=".list-group-item")
	WebElement locDropDown;
	
	@FindBy(xpath="(//section/button)[1]")
	WebElement locOption;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By results = By.cssSelector(".list-group-item");
	
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(searchCountry, countryName).build().perform();;
		waitForElem(By.cssSelector(".list-group-item"));
		locOption.click();
		
		
	}
	
	public confirmationPage submitorder()
	{
		placeOrder.click();
		return new confirmationPage(driver);
	}
	
	
	
	
	
	
	
	
	

}
