package test;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utility.Parametrization;
import utility.Screenshot;

public class LogInFunctionalityParameter 
{
	
WebDriver driver;
	
	@BeforeMethod
	public void openBrowswe()
	{
		 driver= Browser.openChromeBrowser();
	}
	
	@Parameters({"user1","pass1"})
	@Test(priority = 1)
	public void LoginWithValidUseridAndPassword(String userid,String password) throws EncryptedDocumentException, IOException, HeadlessException, AWTException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserID(userid);
		loginPage.enterPassword(password);
		loginPage.clickOnlogin();
		Screenshot.takesScreenShot(driver, "test1");
		
		String ExpectedTitle= "Guru99 Bank Manager HomePage";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		String actualManagerID =  loginPage.getManagerIDText();
		System.out.println(actualManagerID);
		
		String expectedManagerID = "Manger Id : mngr445357";
		
		Assert.assertEquals(actualManagerID, expectedManagerID);
		
		Assert.assertEquals(actualManagerID, expectedManagerID);
		Screenshot.takesScreenShot(driver, "test 1");
		
		
		
		
		
		
	}
	
	@Parameters({"user2","pass2"})
	@Test(priority = 2)
	public void LogInWithInvalidUseridAndValidPassword(String userid,String password) throws EncryptedDocumentException, IOException, InterruptedException, HeadlessException, AWTException
	{
		
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserID(userid);
			
			loginPage.enterPassword(password);
			
			loginPage.clickOnlogin();
			Thread.sleep(1000);
			
			String ExpectedTitle= "Guru99 Bank Manager HomePage";
			String ActualTitle = driver.getTitle();
			Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Parameters({"user3","pass3"})
	@Test(priority = 3)
	public void LogInWithValidUseridAndInvalidPassword(String userid,String password) throws EncryptedDocumentException, IOException, InterruptedException, HeadlessException, AWTException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserID(userid);
		Thread.sleep(1000);
		loginPage.enterPassword(password);
		Thread.sleep(1000);
		loginPage.clickOnlogin();
		
		Thread.sleep(2000);
		String ExpectedTitle= "Guru99 Bank Manager HomePage";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Parameters({"user4","pass4"})
	@Test(priority = 4)
	public void LogInWithInvalidUseridAndInvalidPassword(String userid,String password) throws EncryptedDocumentException, IOException, InterruptedException, HeadlessException, AWTException
	{
		
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserID(userid);
	
			loginPage.enterPassword(password);
		
			loginPage.clickOnlogin();
			System.out.println("before ss");
		
			Thread.sleep(2000);
			String ExpectedTitle= "Guru99 Bank Manager HomePage";
			String ActualTitle = driver.getTitle();
			Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	
	
}
