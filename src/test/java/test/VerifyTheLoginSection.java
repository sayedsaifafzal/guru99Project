package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utility.Parametrization;

public class VerifyTheLoginSection 
{
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowswe()
	{
		 driver= Browser.openChromeBrowser();
	}
	
	
	@Test
	public void VerifyTheLoginFuntionality() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserID(Parametrization.getExcelData("credentials", 0, 1));
		Thread.sleep(1000);
		loginPage.enterPassword(Parametrization.getExcelData("credentials", 1, 1));
		Thread.sleep(1000);
		loginPage.clickOnlogin();
		
		
		
	}
	
	
	@Test
	public void verifyTheTitleOfHomePage() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		String ExpectedTitle = "Guru99 Bank Manager HomePage";
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserID(Parametrization.getExcelData("credentials", 0, 1));
		Thread.sleep(1000);
		loginPage.enterPassword(Parametrization.getExcelData("credentials", 1, 1));
		Thread.sleep(1000);
		loginPage.clickOnlogin();
		Thread.sleep(2000);
		
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);// hard assert
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
