package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy (xpath ="//input[@name='uid']") private WebElement userid;
	@FindBy (xpath = "//input[@name='password']") private WebElement password;
	@FindBy (xpath = "//input[@name='btnLogin']") private WebElement loginButton;
	@FindBy (xpath = "//input[@name='btnReset']") private WebElement resetButton;
	
	@FindBy(xpath = "//td[text()='Manger Id : mngr445357']")private WebElement managerid;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserID(String user)
	{
		userid.sendKeys(user);
	}
	
	public void enterPassword(String pass) 
	{
		password.sendKeys(pass);
	}
	
	public void clickOnlogin()
	{
		loginButton.click();
	}
	
	public void clickOnReset() 
	{
		resetButton.click();
	}
	
	public String getManagerIDText()
	{
		String manager= managerid.getText();
		return manager;
	}
	
	
}
