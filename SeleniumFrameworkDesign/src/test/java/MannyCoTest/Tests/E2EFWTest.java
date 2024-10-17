package MannyCoTest.Tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MannyCoTest.pageobjects.innerFunctions;


public class E2EFWTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		String prodName = "ZARA COAT 3";
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		innerFunctions inFunctions = new innerFunctions(driver);

		
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("moon.jax6@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Emmanuel-12");
		driver.findElement(By.name("login")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List <WebElement> Products =driver.findElements(By.cssSelector(".mb-3"));		
	
		
		WebElement prod = 	Products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().
		equals(prodName)).findFirst().orElse(null);
	
		//w.until(ExpectedConditions.visibilityOf(prod));
		Thread.sleep(2000);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
	w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	
		driver.findElement(By.xpath("(//li/button)[3]")).click();
	
	
		List<WebElement> cartItems = driver.findElements(By.xpath("(//*[@class='cartSection']/h3)[1]"));
		Boolean cartMatch = cartItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(prodName));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='cartSection']/h3")));
		Assert.assertFalse(cartMatch);
	 
	 
		driver.findElement(By.xpath("//li/button[.='Checkout']")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//div/div/input[@placeholder='Select Country']")), "Jamaica").build().perform();
	 
	 
		Thread.sleep(2000L);
		WebElement locDD = driver.findElement(By.xpath("//*[@class='ta-results list-group ng-star-inserted']"));
	w.until(ExpectedConditions.visibilityOf(locDD));
	
		locDD.findElement(By.xpath("//*[@class='ng-star-inserted']")).click();
	
		driver.findElement(By.xpath("(//div/a)[2]")).click();

	
	}

}
