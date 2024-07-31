package DemoSauceLabs;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class TestLogin {
 
  public static void main(String[] args) {

    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();

    driver.get("https://www.saucedemo.com/");

    driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

    driver.findElement(By.xpath("//input[@id='login-button']")).click();

    WebElement applogo = driver.findElement(By.xpath("//div[@class='app_logo']"));
    String exppected_pageTitle = driver.getTitle();

    if(applogo.isDisplayed() == true)
    {
      System.out.println("Login Passed");
    }
    else
    {
      System.out.println("login failed");
    }

    if(exppected_pageTitle.equals("SwagLabs"))
    {
      System.out.println("Login Passed");
    }
    else
    {
      System.out.println("Wrong Data Provided");
    }
    driver.quit();

  }
 
}