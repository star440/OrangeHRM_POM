package ornagehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
 // define elements
	@FindBy(id = "txtUsername")
	WebElement uidelement;
	
	@FindBy(id = "txtPassword")
	WebElement pwdelement;
	
	@FindBy(id = "btnLogin")
	WebElement loginelement;
	
	@FindBy(linkText = "Admin")
	WebElement adminlink;
	
	@FindBy(partialLinkText = "Welcome")
	WebElement welcomelink;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	@FindBy(id = "spanMessage")
	WebElement errmsgelement;
	
// define Functions
	public void login(String uid, String pwd)
	{
		uidelement.sendKeys(uid);
		pwdelement.sendKeys(pwd);
		loginelement.click();
	}
	
	public boolean isAdminModuleDisplayed()
	{
		if(adminlink.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	public void logout()
	{
		welcomelink.click();
		logout.click();
	}

	public boolean isErrMsgDisplayed()
	{
		String errmsg;
		errmsg = errmsgelement.getText().toLowerCase();
		if(errmsg.contains("invalid"))
		{
			return true;	
		}else
		{
			return false;
		}
	}

}
