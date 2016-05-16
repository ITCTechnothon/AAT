package com.itc.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itc.util.BasePageObject;

public class LoginPage extends BasePageObject{

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//WebElement element=null;
		
	/*Variables*/
		
	boolean flag = false;
	List<WebElement> list=null;
	String txt = null;
	
	/*Web elements*/
	
	By msgLoginPage = By.xpath("//span[contains(text(),'Login To Your Aynax Account')]");
	
	

	/**
	 * This method helps us to find the Login page
	 * @return boolean
	 * @param No param
	 * @throws Exception
	 */
	public boolean isLoginPageDisplayed() throws Exception
	{
		try 
		{
			flag = isElementPresent(msgLoginPage);
			if (flag) 
			{
			System.out.println("Login pag is displayed");	
			}			
			else
			{
				System.out.println("Login page is displayed");
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("Login page is displayed::"+isLoginPageDisplayed()+e.getLocalizedMessage());
		}
		return flag;
	}
	
}
