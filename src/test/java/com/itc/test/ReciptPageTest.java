package com.itc.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itc.pages.ReciptPage;
import com.itc.util.BaseTestObject;

public class ReciptPageTest extends BaseTestObject{

	ReciptPage objReciptPage = null;
	LoginPageTest login=new LoginPageTest();
	boolean flag = false;
	boolean flag1 = false;
	boolean flag2=false;
	boolean titleflag=false;

	@Parameters({"browserType","url"})
	@Test(priority=0, enabled=true,groups="SanityTest")
	public void Login() throws Exception{
		login.verifyLoginPage();
		
	}
	
	@Test(priority=1, enabled=true,groups="SanityTest")
	public void reciptTabdisplay() throws Exception
	{
	try 
	{
		objReciptPage = new ReciptPage(driver);
		objReciptPage.clickOnLisRecipt();
	} 
	
	catch (Exception e) 
	{
		throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}
	}
	@Test(priority=1, enabled=true,groups="SanityTest")
	public void verifyuploadRecipt() throws Exception
	{
	try 
	{
	    objReciptPage.uploadRecipt();;
	    flag1=objReciptPage.isResultPageDisplayed();
	    titleflag= objReciptPage.isTitleDisplayed();
	    
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
		//throw new Exception("FAILED CLICK ON SITELOGO AND VERFIY PAGETITLE TESTCASE" + "\n clickOnSiteLogoAndCheckThePageTitle" +e.getLocalizedMessage());
	}

	}
	
	

	
	
}
