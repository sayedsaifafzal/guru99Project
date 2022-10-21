package test;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utility.Parametrization;
import utility.Screenshot;

public class VerifyTheLogInFunctionality
{

WebDriver driver;
	
	@BeforeMethod
	public void openBrowswe()
	{
		 driver= Browser.openChromeBrowser();
	}
	
	@Test(priority = 1)
	public void LoginWithValidUseridAndPassword() throws EncryptedDocumentException, IOException, HeadlessException, AWTException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserID(Parametrization.getExcelData("credentials", 0, 1));
		loginPage.enterPassword(Parametrization.getExcelData("credentials", 1, 1));
		loginPage.clickOnlogin();
		Screenshot.takesScreenShot(driver, "test1");
		
		String ExpectedTitle= "Guru99 Bank Manager HomePage";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		

		String actualManagerID =  loginPage.getManagerIDText();
		System.out.println(actualManagerID);
		
		String expectedManagerID = "Manger Id : mngr445357";
		
		Assert.assertEquals(actualManagerID, expectedManagerID);
		Screenshot.takesScreenShot(driver, "test 1");
		
		
		
	}
	
	@Test(priority = 2)
	public void LogInWithInvalidUseridAndValidPassword() throws EncryptedDocumentException, IOException, InterruptedException, HeadlessException, AWTException
	{
		
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserID(Parametrization.getExcelData("credentials", 3, 1));
			
			loginPage.enterPassword(Parametrization.getExcelData("credentials", 1, 1));
			
			loginPage.clickOnlogin();
			Thread.sleep(1000);
			//Screenshot.takesScreenShot(driver, "test2");
//			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//			ImageIO.write(image, "png", new File("C:\\Users\\dell\\Desktop\\java project\\guru99\\ScreenShot\\"+"robotscreenshot test2"+".png"));
		
			
			String ExpectedTitle= "Guru99 Bank Manager HomePage";
			String ActualTitle = driver.getTitle();
			Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test(priority = 3)
	public void LogInWithValidUseridAndInvalidPassword() throws EncryptedDocumentException, IOException, InterruptedException, HeadlessException, AWTException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserID(Parametrization.getExcelData("credentials", 0, 1));
		Thread.sleep(1000);
		loginPage.enterPassword(Parametrization.getExcelData("credentials", 3, 1));
		Thread.sleep(1000);
		loginPage.clickOnlogin();
		//Screenshot.takesScreenShot(driver, "test3");
//		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//		ImageIO.write(image, "png", new File("C:\\Users\\dell\\Desktop\\java project\\guru99\\ScreenShot\\"+"robotscreenshot test3"+".png"));
//	
		Thread.sleep(2000);
		String ExpectedTitle= "Guru99 Bank Manager HomePage";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	
	}
	
	@Test(priority = 4)
	public void LogInWithInvalidUseridAndInvalidPassword() throws EncryptedDocumentException, IOException, InterruptedException, HeadlessException, AWTException
	{
		//try
			//{
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserID(Parametrization.getExcelData("credentials", 3, 1));
	
			loginPage.enterPassword(Parametrization.getExcelData("credentials", 6, 1));
		
			loginPage.clickOnlogin();
			System.out.println("before ss");
		//	Screenshot.takesScreenShot(driver, "test4");
//			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//			ImageIO.write(image, "png", new File("C:\\Users\\dell\\Desktop\\java project\\guru99\\ScreenShot\\"+"robotscreenshot test4"+".png"));
			
			
			
			
		//	}
			//catch (Exception e)
			//{
				// TODO: handle exception
				//Screenshot.takesScreenShot(driver, "test4");
				//System.out.println("after ss");
		//	}
			Thread.sleep(2000);
			String ExpectedTitle= "Guru99 Bank Manager HomePage";
			String ActualTitle = driver.getTitle();
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		
		
		
	}
	
	
	
	
	
	
}
