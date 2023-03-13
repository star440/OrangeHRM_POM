package orangehrm.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import ornagehrm.pages.LoginPage;
import utils.AppUtils;
import utils.XLutils;

public class AdminLoginwithValidInputs extends AppUtils
 {
	String xlfile = "C:\\Selenium\\OrangeHRM_POM\\Datafiles\\OrangeHRM.xlsx";
	String xlsheet = "AdminLoginValidData";
	String adminuid, adminpwd;
	
	@Test
   public void checkadminlogin() throws IOException
   {
	  LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
	  int rowcount;
	  rowcount = XLutils.getRowCount(xlfile, xlsheet);
	  for(int i=1; i<=rowcount; i++)
	  {
		  adminuid = XLutils.getCellStringData(xlfile, xlsheet, i, 0);
		  adminpwd = XLutils.getCellStringData(xlfile, xlsheet, i, 1);
		  lp.login(adminuid, adminpwd);
		 boolean res = lp.isAdminModuleDisplayed();
		 if(res)
		 {
			 XLutils.setCellData(xlfile, xlsheet, i, 2, "Pass");
			 XLutils.setGreenColor(xlfile, xlsheet, i, 2);
		 }else
		 {
			 XLutils.setCellData(xlfile, xlsheet, i, 2, "Fail");
			 XLutils.setRedColor(xlfile, xlsheet, i, 2);
		 }
		 lp.logout();
	  }
	 
	   
   }
	
	
	

}


