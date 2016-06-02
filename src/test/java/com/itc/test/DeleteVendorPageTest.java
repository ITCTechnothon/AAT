package com.itc.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itc.pages.DeleteVendorPage;
import com.itc.util.BaseTestObject;

import junit.framework.Assert;


public class DeleteVendorPageTest extends BaseTestObject{

	DeleteVendorPage objDeleteVendorPage =null;
	LoginPageTest login=new LoginPageTest();
	boolean flag = false;
	boolean flag1 = false;
	String titleflag=null;
		
	@Parameters({"browserType"})
	@Test(priority=0, enabled=true,groups="Regression")
	public void Login() throws Exception{
		login.verifyLoginPage();
		
	}
	
	@Test(priority=1, enabled=true,groups="Regression")
	public void verifyDeleteVendor1() throws Exception
	{
	try 
	{
		objDeleteVendorPage = new DeleteVendorPage(driver);
		objDeleteVendorPage.clickOnListVendor();
		objDeleteVendorPage.vendorDeletion1();
		/*String title=objDeleteVendorPage.isTitleDisplayed();
		Assert.assertTrue(title.contains("List of Vendors:"));*/
	    flag1=objDeleteVendorPage.isResultPageDisplayed();
	    Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
	@Test(priority=1, enabled=true,groups="Regression")
	public void verifyDeleteVendor2() throws Exception
	{
	try 
	{
		objDeleteVendorPage = new DeleteVendorPage(driver);
		objDeleteVendorPage.clickOnListVendor();
		objDeleteVendorPage.vendorDeletion2();
		/*String title=objDeleteVendorPage.isTitleDisplayed();
		Assert.assertTrue(title.contains("List of Vendors:"));*/
	    flag1=objDeleteVendorPage.isResultPageDisplayed();
	    Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
}
