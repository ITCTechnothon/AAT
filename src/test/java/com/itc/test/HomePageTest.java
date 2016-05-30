package com.itc.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itc.pages.HomePage;
import com.itc.pages.LoginPage;
import com.itc.util.BaseTestObject;


public class HomePageTest extends BaseTestObject{

	HomePage objHomePage = null;
	LoginPage objLoginPage = null;
	boolean flag = false;
	
	@Parameters({"browserType","url"})
	@Test(priority=0, enabled=true,groups="Regression")
	public void verifyHomePage() throws Exception
	{
	try 
	{
		objHomePage = new HomePage(driver);
		flag = objHomePage.isSiteLogoDisplayed();
	    Assert.assertTrue(flag, "Site logo is not displayed");
	    objLoginPage = objHomePage.clickOnLogin();
	    
	    flag = objLoginPage.isLoginPageDisplayed();
	    Assert.assertTrue(flag, "Login page is not displayed");
	    
	    //String valuefromExcel = getValFromExcel(row, col);
	} 
	catch (Exception e) 
	{
		throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}

	}
	
	
	/*public static String getValFromExcel(int row,int col) throws Exception{
		
		ExcelutilObject.setExcelFile("", "");
		return ExcelutilObject.getCellData(RowNum, ColNum);
	}
*/}
