package MannyCoTest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import MannyCoTest.abstractOps.abstractOpers;

public class CartPage extends abstractOpers {
	WebDriver driver;
	
	@FindBy (css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy (css="div[class='cartSection'] h3")
	List<WebElement> cartTiles;
	
	By carttiles = By.cssSelector("div[class='cartSection'] h3");
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public Boolean verifyProductDisplay(String prodName) 
	{
	waitForElem(carttiles);
	Boolean cartMatch = cartTiles.stream().anyMatch(cart->cart.getText().
			equalsIgnoreCase(prodName));
	return cartMatch;
	}
	
	public checkOutPage goToCheckO()
	{
		checkoutEle.click();
		return new checkOutPage(driver);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

