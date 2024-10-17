package MannyCoTest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MannyCoTest.abstractOps.abstractOpers;

public class OrderHist extends abstractOpers {

	WebDriver driver;
	public OrderHist(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	By orderValid = By.xpath("//tr/td[2]");
	
	@FindBy (xpath="//tr/td[2]")
	List <WebElement> orderTableValid;

	public Boolean orderTable(String prodName)
	{
		waitForElem(orderValid);
		Boolean orderMatch = orderTableValid.stream().anyMatch(order->order.getText().
				equalsIgnoreCase(prodName));
		return orderMatch;
	}

	
	
	
}
