package loginpackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class loginpage {
	public WebDriver driver; 
	String email_text ="testtoday1@gmail.com";
	String pass_text ="12345678";
  @Test (priority=1,enabled =false)
  public void Tc_001() throws InterruptedException {
	  	WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//input[@id='kc-login']")); 
		email.sendKeys(email_text);
		password.sendKeys(pass_text);
		login.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@alt='Vue logo']")).isDisplayed();
		System.out.println("login successfully");
  }
  @Test (priority=2,enabled =false)
  public void Tc_003() throws InterruptedException {
	  	WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//input[@id='kc-login']"));
		email.sendKeys(email_text);
		password.sendKeys(pass_text);
		login.click();
		if(driver.findElement(By.xpath("//span[@id='input-error']")).isDisplayed()) {
			String errmsg = driver.findElement(By.xpath("//span[@id='input-error']")).getText();
			System.out.println("error is :" +errmsg);
		}
		
  }
  @Test (priority=3,enabled =false)
  public void Tc_006() throws InterruptedException {
	  	WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement forgot_pass = driver.findElement(By.xpath("//input[@id='rememberMe']")); 
		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));
		forgot_pass.click();
		Thread.sleep(500);
		email.sendKeys(email_text);
		submit.click();
		String msg = driver.findElement(By.xpath("//span[@class='pf-c-alert__title kc-feedback-text']")).getText();
		System.out.println("message :" +msg);
		
  }
  @Test (priority=4,enabled =false)
  public void Tc_010() throws InterruptedException {
	  	WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement remember_me = driver.findElement(By.xpath("//input[@id='rememberMe']"));
		WebElement login = driver.findElement(By.xpath("//input[@id='kc-login']"));
		email.sendKeys(email_text);
		password.sendKeys(pass_text);
		remember_me.click();
		login.click();	
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@alt='Vue logo']")).isDisplayed();
		System.out.println("login successfully");

  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\OneDrive\\Desktop\\vishnu\\chromedriver_win32\\chromedriver.exe");
	 ChromeOptions option = new ChromeOptions();
	option.addArguments("incognito");
	
	 driver = new ChromeDriver(option);
	  
		//WebDriver driver = new ChromeDriver();
	  	
		driver.manage().window().maximize();
		driver.get("https://console.uat.asians.group/#/domain/list");
		//driver.get("https://user.asians.group/auth/realms/asians/protocol/openid-connect/auth?client_id=public&redirect_uri=https%3A%2F%2Fconsole.uat.asians.group%2F%23%2Fdomain%2Flist&state=75c41f52-1e0b-4800-839b-5fb4fa3aa182&response_mode=fragment&response_type=code&scope=openid&nonce=15c3be16-b8c8-4550-83f5-079fdcf9e2f4");
		Thread.sleep(20000);
		System.out.println("flow here");
	/*
	 * WebElement s =driver.findElement(By.xpath("//span[text()='New user? ']/a"));
	 * s.click();  */
	 
        
  }

@AfterTest
public void afterTest() {
 driver.close();
}   


}
