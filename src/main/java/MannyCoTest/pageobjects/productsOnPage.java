package MannyCoTest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import MannyCoTest.abstractOps.abstractOpers;

public class productsOnPage extends abstractOpers{
	
	WebDriver driver;
	public productsOnPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy (xpath="(//li/button[@class='btn btn-custom'])[2]")
	WebElement orderHsButton;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCartBtn = By.cssSelector(".card-body button:last-of-type");
	By addedCartMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProducts()
	{
		waitForElem(productsBy);
		return products;
	}
	
	
	public WebElement getProductByName(String prodName) 
	{
		WebElement prod = 	getProducts().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().
		equals(prodName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String prodName) throws InterruptedException
	{
		WebElement prod = getProductByName(prodName);
		prod.findElement(addToCartBtn).click();		
		waitForElem(addedCartMsg);
		waitForElementDissapear(spinner);
		
	}
	
	public OrderHist toOrderHistory()
	{
		waitForWebElem(orderHsButton);
		orderHsButton.click();
		OrderHist orderHS = new OrderHist(driver);
		return orderHS;
	}
	
	
	
}
