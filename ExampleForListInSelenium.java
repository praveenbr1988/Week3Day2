package week3Day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
			Thread.sleep(3000);
			} 
		catch(StaleElementReferenceException e){
			driver.navigate().to(driver.getCurrentUrl()); 
			fashionbag =driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']"));
			fashionbag.click(); 
			Thread.sleep(3000);
			}
	
		String totalitemstext = driver.findElement(By.className("length")).getText();
		totalitemstext = totalitemstext.replaceAll("[^0-9]", "").trim();
		int totalitems= Integer.parseInt(totalitemstext);
		System.out.println("Total Items found: "+totalitems);
		
		//WebElement scrollposition = driver.findElement(By.className("ic-update"));
		boolean endOfPage = false;
		String previousPageSource = driver.getPageSource();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		while (!endOfPage)
		{
			//js.executeScript("arguments[0].scrollIntoView();", scrollposition);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			Thread.sleep(5000);
		    endOfPage = previousPageSource.equals(driver.getPageSource());
		    previousPageSource = driver.getPageSource();
		}
		
		
		List<WebElement> listofbrands = driver.findElements(By.xpath("//div[@class=\"brand\"]"));
		
		System.out.println("List of brands: "+listofbrands.size());
		  
		//Printing the List
		for (WebElement webElement : listofbrands) {
			System.out.println(webElement.getText());
		}
		
		//Converting into Set and printing the set
		Set<WebElement> tset = new TreeSet<WebElement>(listofbrands);
		System.out.println("Total unique brands: "+tset.size());
		for (WebElement webElement : tset) {
			System.out.println(webElement.getText());
		}

		List<WebElement> listofbagnames = driver.findElements(By.xpath("//div[@class=\"nameCls\"]"));
		System.out.println("Total bags: "+listofbagnames.size());
		for (WebElement webElement : listofbagnames) {
			System.out.println(webElement.getText());
		}
		
		
	
	}

}
