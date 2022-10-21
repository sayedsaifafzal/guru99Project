package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser 
{
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\SELENIUM\\chromedriver_win32\\chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.demo.guru99.com/V4/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		return driver;
		
		
		
	}
	
	
	
	
}


