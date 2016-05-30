package com.itc.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itc.pages.EditVendorPage;
import com.itc.util.BaseTestObject;
import com.itc.util.ExcelutilObject;

import junit.framework.Assert;


public class EditVendorPageTest extends BaseTestObject{

	EditVendorPage objEditVendorPage = null;
	LoginPageTest login=new LoginPageTest();
	boolean flag = false;
	boolean flag1 = false;
	String titleflag=null;
	public static String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testDataSheet.xlsx";

	@Parameters({"browserType","url"})
	@Test(priority=0, enabled=true,groups="Regression")
	public void Login() throws Exception{
		login.verifyLoginPage();
		
	}
	@Test(priority=1, enabled=true)
	public void expenseTabdisplayed() throws Exception
	{
	try 
	{
		objEditVendorPage = new EditVendorPage(driver);
		objEditVendorPage.clickOnListVendorLink();
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
	@Test(priority=2, enabled=true,groups="Regression")
	public void verifyEditVendor1() throws Exception
	{
	try 
	{
		String vendorname =getValFromExcel(1,2);
	    String address =getValFromExcel(1,3);
	    objEditVendorPage = new EditVendorPage(driver);
		objEditVendorPage.isTitleDisplayed();
		//Assert.assertTrue(title.contains("Edit Vendor:"));
		objEditVendorPage.clickOnVendorLink1(); 
		objEditVendorPage.EditVendor(vendorname, address);
	    flag1=objEditVendorPage.isResultPageDisplayed();
	    Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
	@Test(priority=3, enabled=true,groups="Regression")
	public void verifyEditVendor2() throws Exception
	{
	try 
	{
		objEditVendorPage = new EditVendorPage(driver);
		expenseTabdisplayed();
		String vendorname =getValFromExcel(2,2);
	    String address =getValFromExcel(2,3);
		objEditVendorPage.isTitleDisplayed();
		objEditVendorPage.clickOnVendorLink2(); 
		objEditVendorPage.EditVendor(vendorname, address);
	    flag1=objEditVendorPage.isResultPageDisplayed();
	    Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
	@Test(priority=3, enabled=true,groups="Regression")
	public void verifyEditVendor3() throws Exception
	{
	try 
	{
		objEditVendorPage = new EditVendorPage(driver);
		expenseTabdisplayed();
		String vendorname =getValFromExcel(5,2);
	    String address =getValFromExcel(5,3);
		objEditVendorPage.isTitleDisplayed();
		objEditVendorPage.clickOnVendorLink2(); 
		objEditVendorPage.EditVendor(vendorname, address);
	    objEditVendorPage.isResultPageDisplayed();
	    //Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
public static String getValFromExcel(int row,int col) throws Exception{
		
		ExcelutilObject.setExcelFile(excelPath, "EditVendorData");
		return ExcelutilObject.getCellData(row, col);
	}

	
}
