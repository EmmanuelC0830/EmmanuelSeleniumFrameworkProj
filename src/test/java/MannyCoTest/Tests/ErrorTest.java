package MannyCoTest.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MannyCoTest.TestComponents.Base;
import MannyCoTest.TestComponents.retry;
import MannyCoTest.pageobjects.CartPage;
import MannyCoTest.pageobjects.checkOutPage;
import MannyCoTest.pageobjects.confirmationPage;
import MannyCoTest.pageobjects.innerFunctions;
import MannyCoTest.pageobjects.productsOnPage;


public class ErrorTest extends Base {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer= retry.class)
	public void lognErrorValid () throws IOException, InterruptedException
	{
		String prodName = "ZARA COAT 3";
		productsOnPage productsPage = inFunctions.loginIn("moon-jax6@gmail.com","Emman12");
		Assert.assertEquals("Incorrect email or password." , inFunctions.getErrorMsg());

	}
	
	@Test
	public void productErrorValid() throws IOException, InterruptedException
	{
		String prodName = "ZARA COAT 3";
		productsOnPage productsPage = inFunctions.loginIn("ssmanny1@hotmail.com","Emmanuel12");
		
		List<WebElement> Products = productsPage.getProducts();
		productsPage.addToCart(prodName);
		CartPage cartPage =productsPage.navToCart();
		
		Boolean cartMatch = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(cartMatch);
		
	}


}
