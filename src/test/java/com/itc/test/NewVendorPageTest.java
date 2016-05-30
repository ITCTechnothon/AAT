package com.itc.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itc.pages.NewVendorPage;
import com.itc.util.BaseTestObject;
import com.itc.util.ExcelutilObject;

public class NewVendorPageTest extends BaseTestObject{

	NewVendorPage objNewVendorPage = null;
	LoginPageTest login=new LoginPageTest();
	boolean flag = false;
	boolean flag1 = false;
	boolean flag2=false;
	boolean titleflag=false;
	public static String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testDataSheet.xlsx";

	@Parameters({"browserType","url"})
	@Test(priority=0, enabled=true)
	public void Login() throws Exception{
		login.verifyLoginPage();
		
	}
	
	@Test(priority=1, enabled=true,groups="Regression")
	public void expenseTabdisplay() throws Exception
	{
	try 
	{
		objNewVendorPage = new NewVendorPage(driver);
		objNewVendorPage.clickOnNewVendor();
	} 
	
	catch (Exception e) 
	{
		throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}
	}
	@Test(priority=1, enabled=true,groups="Regression")
	public void verifyNewVendor1() throws Exception
	{
	try 
	{
	    String vendorName =getValFromExcel(1,2);
	    String address =getValFromExcel(1,3);
		objNewVendorPage.VendorCreation(vendorName,address);
	    objNewVendorPage.isResultPageDisplayed();
	   // AynaxUtil.implicitWait(20);
	   // Assert.assertTrue(flag1);
	    titleflag= objNewVendorPage.isTitleDisplayed();
	    
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
		//throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}

	}
	@Test(priority=1, enabled=true)
	public void verifyNewVendor2() throws Exception
	{
	try 
	{
		objNewVendorPage.clickOnNewVendor();
	    String vendorName =getValFromExcel(2,2);
	    String address =getValFromExcel(2,3);
	    
		objNewVendorPage.VendorCreation(vendorName,address);
	    objNewVendorPage.isResultPageDisplayed();
	   // AynaxUtil.implicitWait(20);
	   // Assert.assertTrue(flag1);
	    titleflag= objNewVendorPage.isTitleDisplayed();
	    
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
		//throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}

	}
	@Test(priority=1, enabled=true,groups="Regression")
	public void verifyNewVendor3() throws Exception
	{
	try 
	{
		objNewVendorPage.clickOnNewVendor();
	    String vendorName =getValFromExcel(5,5);
	    String address =getValFromExcel(6,6);
	    
		objNewVendorPage.VendorCreation(vendorName,address);
	    objNewVendorPage.isResultPageDisplayed();
	    titleflag= objNewVendorPage.isTitleDisplayed();
	    
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
		//throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}

	}
public static String getValFromExcel(int row,int col) throws Exception{
		
		ExcelutilObject.setExcelFile(excelPath, "VendorData");
		return ExcelutilObject.getCellData(row, col);
	}

	
	
}
