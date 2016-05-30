package com.itc.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itc.pages.EditAccountListTransaction;
import com.itc.util.BaseTestObject;
import com.itc.util.ExcelutilObject;

import junit.framework.Assert;


public class EditAccounListTransactionTest extends BaseTestObject{

	EditAccountListTransaction objEditAccountPage=null ;
	LoginPageTest login=new LoginPageTest();
	boolean flag = false;
	boolean flag1 = false;
	String titleflag=null;
	public static String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testDataSheet.xlsx";

	@Parameters({"browserType","url"})
	@Test(groups="Regression")
	public void Login() throws Exception{
		login.verifyLoginPage();
	}
	
	
	@Test(priority=2, enabled=true,groups="Regression")
	public void verifyEditAccount1() throws Exception
	{
	try 
	{
		objEditAccountPage= new EditAccountListTransaction(driver);
		objEditAccountPage.clickOnChartAccount();
		String vendorname =getValFromExcel(1,2);
	    String address =getValFromExcel(1,3);
		//objEditVendorPage.clickOnVendorLink();
		objEditAccountPage.isTitleDisplayed();
		//Assert.assertTrue(title.contains("Edit Vendor:"));
		objEditAccountPage.clickOnAccountLink1(); 
		objEditAccountPage.editExpense(vendorname, address);
	    flag1=objEditAccountPage.isResultPageDisplayed();
	    Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
	@Test(priority=3, enabled=true,groups="Regression")
	public void verifyEditAccount2() throws Exception
	{
	try 
	{
		objEditAccountPage= new EditAccountListTransaction(driver);
		objEditAccountPage.clickOnChartAccount();
		String vendorname =getValFromExcel(2,2);
	    String address =getValFromExcel(2,3);
		objEditAccountPage.isTitleDisplayed();
		objEditAccountPage.clickOnAccountLink2(); 
		objEditAccountPage.editExpense(vendorname, address);
	    flag1=objEditAccountPage.isResultPageDisplayed();
	    Assert.assertTrue(flag1);
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
	//@Test(priority=3, enabled=true,groups="Regression")
	public void verifyEditAccount3() throws Exception
	{
	try 
	{
		objEditAccountPage= new EditAccountListTransaction(driver);
		objEditAccountPage.clickOnChartAccount();
		String vendorname =getValFromExcel(8,8);
	    String address =getValFromExcel(2,3);
		objEditAccountPage.isTitleDisplayed();
		objEditAccountPage.clickOnAccountLink2(); 
		objEditAccountPage.editExpense(vendorname, address);
	   objEditAccountPage.isResultPageDisplayed();
	        
	} 
	
	catch (Exception e) 
	{
		e.printStackTrace();
	}

	}
public static String getValFromExcel(int row,int col) throws Exception{
		
		ExcelutilObject.setExcelFile(excelPath, "EditAccountData");
		return ExcelutilObject.getCellData(row, col);
	}


}
