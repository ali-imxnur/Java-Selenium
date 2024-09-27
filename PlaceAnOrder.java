package DemoSauceLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlaceAnOrder {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		WebElement applogo = driver.findElement(By.xpath("//div[@class='app_logo']"));
		String exppected_pageTitle = driver.getTitle();
		System.out.println(exppected_pageTitle);
		
		if(applogo.isDisplayed() == true)
		{
			System.out.println("Login Passed Successfully");
		}
		else
		{
			System.out.println("login failed");
		}
		
		WebElement backpack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		backpack.click();
		WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		cart.click();
		WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
		checkout.click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("IMANUR");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("ALI");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("736168");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		WebElement complete_header = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		
		if(complete_header.isDisplayed() == true) {
			System.out.println("Order Placed");
		}
		else {
			System.out.println("Order Not Placed");
		}
		
		driver.quit();
		
	}

}
