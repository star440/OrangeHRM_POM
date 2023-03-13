package orangehrm.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import graphql.Assert;
import ornagehrm.pages.LoginPage;
import utils.AppUtils;
import utils.XLutils;

public class LoginwithInvalidInputs extends AppUtils
{
	String xlfile = "C:\\Selenium\\OrangeHRM_POM\\Datafiles\\OrangeHRM.xlsx";
	String xlsheet = "AdminLoginInvalidData";
	String uid, pwd;
	LoginPage lp;
	@Test
  public void logincheck() throws IOException
  {
	lp = PageFactory.initElements(driver, LoginPage.class);
    int rowcount;
    rowcount = XLutils.getRowCount(xlfile, xlsheet);
    for(int i=1;i<=rowcount;i++)
    {
    	uid = XLutils.getCellStringData(xlfile, xlsheet, i, 0);
    	pwd = XLutils.getCellStringData(xlfile, xlsheet, i, 1);
    	lp.login(uid, pwd);
    	boolean res = lp.isErrMsgDisplayed();
    	Assert.assertTrue(res);
    	if(res)
    	{
    		XLutils.setCellData(xlfile, xlsheet, i, 2, "Pass");
    		XLutils.setGreenColor(xlfile, xlsheet, i, 2);
    	}else
    	{
    		XLutils.setCellData(xlfile, xlsheet, i, 2, "Fail");
    		XLutils.setRedColor(xlfile, xlsheet, i, 2);
    	}
    }
  
  
  
  }}
