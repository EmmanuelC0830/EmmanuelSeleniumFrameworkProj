package MannyCoTest.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MannyCoTest.TestComponents.Base;
import MannyCoTest.pageobjects.CartPage;
import MannyCoTest.pageobjects.OrderHist;
import MannyCoTest.pageobjects.checkOutPage;
import MannyCoTest.pageobjects.confirmationPage;
import MannyCoTest.pageobjects.productsOnPage;


public class SubmitOrderTests extends Base {
	String prodName = "ZARA COAT 3";

	
	@Test(dataProvider = "getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		productsOnPage productsPage = inFunctions.loginIn(input.get("email"), input.get("password"));
		
		List<WebElement> Products = productsPage.getProducts();
		productsPage.addToCart(input.get("product"));
		CartPage cartPage =productsPage.navToCart();
		
		Boolean cartMatch = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(cartMatch);
		checkOutPage checkoutpage = cartPage.goToCheckO();
		checkoutpage.selectCountry("Jamai");

		WebElement Submit = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Submit);
		
		confirmationPage confirmationP = new confirmationPage(driver);
		String confirmMessage = confirmationP.getConfirmationMsg();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	
	}
	
	@Test(dependsOnMethods={"submitOrder"})
	public void OrderHistoryValidation() throws InterruptedException
	{
		productsOnPage productsPage = inFunctions.loginIn("moon.jax6@gmail.com","Emmanuel-12");
		OrderHist orderHS = productsPage.toOrderHistory();
		Boolean orderListValid = orderHS.orderTable(prodName);
		Assert.assertTrue(orderListValid);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
	
		List<HashMap<String, String>> data =jsonToMap(System.getProperty("user.dir")+"//src//test//java//MannyCoTest//data//jsonData.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}



}
