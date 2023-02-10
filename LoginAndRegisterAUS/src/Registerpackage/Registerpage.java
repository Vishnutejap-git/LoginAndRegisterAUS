package Registerpackage;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Registerpage {
	public WebDriver driver; 
 
	String email_key = "testtoday22@gmail.com";
	String password_key = "12345678";
	String confirmpass_key = "12345678";
	
  @Test(priority=1,enabled=true)
  public void Tc_001() {
	  
	   	System.out.println("flow");
	   	WebElement s =driver.findElement(By.xpath("//span[text()='New user? ']/a"));
		  s.click();
 
  }

	@Test(priority = 2,  dependsOnMethods = { "Tc_001" }, enabled=false)
  public void Tc_003_to_010() throws InterruptedException {
	  	WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement confirmpass = driver.findElement(By.xpath("//input[@name='password-confirm']"));
		WebElement Registerbtn = driver.findElement(By.xpath("//input[@value='Register']"));
		email.sendKeys(email_key);
		password.sendKeys(password_key);
		confirmpass.sendKeys(confirmpass_key);
		Registerbtn.click();
		
		driver.findElement(By.xpath("//span[@class='pf-c-alert__title kc-feedback-text']"));
		
		String errmsg = driver.findElement(By.xpath("//span[@class='pf-c-alert__title kc-feedback-text']")).getText();
		System.out.println("error is :" +errmsg);
		
  }
	@Test(priority = 3,  dependsOnMethods = { "Tc_001" }, enabled=false)
	  public void Tc_012() throws InterruptedException {
		WebElement backtologin = driver.findElement(By.xpath("//a[text()='« Back to Login']"));
		backtologin.click();
		Thread.sleep(1000);
		WebElement login_page = driver.findElement(By.xpath("//h1[@id='kc-page-title']"));
		String msg = login_page.getText();
		System.out.println("Redirected to login page " +msg);
		
	}
	@Test(priority = 4,  dependsOnMethods = { "Tc_001" }, enabled=true)
	  public void Tc_013() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement confirmpass = driver.findElement(By.xpath("//input[@name='password-confirm']"));
		WebElement Registerbtn = driver.findElement(By.xpath("//input[@value='Register']"));
		email.sendKeys(email_key);
		password.sendKeys(password_key);
		confirmpass.sendKeys(confirmpass_key);
		Registerbtn.click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@alt='Vue logo']")).isDisplayed();
		System.out.println("Registered successfully");
	}
	
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\OneDrive\\Desktop\\vishnu\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions option = new ChromeOptions();
		option.addArguments("incognito");
		
		 driver = new ChromeDriver(option);
		  
			
		  	
			driver.manage().window().maximize();
			driver.get("https://console.uat.asians.group/#/domain/list");
			Thread.sleep(20000);
			System.out.println("flow here");

		 
	        
	  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }   

}
