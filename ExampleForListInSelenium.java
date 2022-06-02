package week3Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleForListInSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("http://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("searchVal")).sendKeys("bags");
		driver.findElement(By.name("searchVal")).sendKeys(Keys.RETURN);
		WebElement gender = driver.findElement(By.xpath("//label[contains(text(),\"Men\")]"));
		gender.click();
		
		WebElement fashionbag = driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']"));		
		Thread.sleep(3000);
				
		try { 
			fashionbag.click(); 
			} 
		catch(StaleElementReferenceException e){
			driver.navigate().to(driver.getCurrentUrl()); 
			fashionbag =driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']"));
			fashionbag.click(); 
			}
	
		String totalitemstext = driver.findElement(By.className("length")).getText();
		String[] arrstr = totalitemstext.split(" ");
		Integer totalitems= Integer.parseInt(arrstr[0]);
		System.out.println("Total Items found: "+totalitems);
		
		WebElement scrollposition = driver.findElement(By.className("ic-update"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollposition);
		Thread.sleep(20000);
		
		List<WebElement> listofbrands = driver.findElements(By.xpath("//div[@class=\"brand\"]"));
		System.out.println("Total brands: "+listofbrands.size());
		for (WebElement webElement : listofbrands) {
			System.out.println(webElement.getText());
		}
		
		List<WebElement> listofbagnames = driver.findElements(By.xpath("//div[@class=\"nameCls\"]"));
		System.out.println("Total bags: "+listofbagnames.size());
		for (WebElement webElement : listofbagnames) {
			System.out.println(webElement.getText());
		}
		
		
		
		
		
	}

}
