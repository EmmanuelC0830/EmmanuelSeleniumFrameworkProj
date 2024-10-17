package MannyCoTest.StepDefs;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MannyCoTest.TestComponents.Base;
import MannyCoTest.pageobjects.CartPage;
import MannyCoTest.pageobjects.checkOutPage;
import MannyCoTest.pageobjects.confirmationPage;
import MannyCoTest.pageobjects.innerFunctions;
import MannyCoTest.pageobjects.productsOnPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefInit extends Base{

	public innerFunctions inFunctions;
	public productsOnPage productsPage;
	public checkOutPage checkoutpage;
	public confirmationPage confirmationP;
	public productsOnPage products;
	
@Given("I landed on the Ecommerce page")
public void login_to_page() throws IOException
{
	inFunctions= launchApp();
	
}

@Given("^Logged in with a valid username (.+) and password (.+)$")
public void Logging_into_Web(String username, String password) 
{
	 productsPage=inFunctions.loginIn(username, password);

	
}

@When("^I add product (.+) to the cart$")
public void Adding_to_cart(String product) throws InterruptedException 
{
	List<WebElement> Products = productsPage.getProducts();
	productsPage.addToCart(product);
}

@And("^checkout product (.+) and submit the order$")
public void Nav_and_Submit(String prodName) 
{
	CartPage cartPage =productsPage.navToCart();
	
	Boolean cartMatch = cartPage.verifyProductDisplay(prodName);
	Assert.assertTrue(cartMatch);
	checkOutPage checkoutpage = cartPage.goToCheckO();
	checkoutpage.selectCountry("Jamai");	
	WebElement Submit = driver.findElement(By.cssSelector(".action__submit"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", Submit);

}


@Then("{string} message is displayed on confirmationPage")
public void Confirm_message(String string) 
{
	confirmationPage confirmationP = new confirmationPage(driver);
	String confirmMessage = confirmationP.getConfirmationMsg();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	driver.close();
	
}

@Then("{string} message is displayed on the login page")
public void Confirm_incorrect_message(String string1) throws Throwable
{
	Assert.assertEquals(string1 , inFunctions.getErrorMsg());
	
}










}
