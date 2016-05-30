package com.itc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.itc.common.AynaxUtil;
import com.itc.util.BasePageObject;
import com.itc.util.ExcelutilObject;

public class EditExpensePage extends BasePageObject {

	public EditExpensePage(WebDriver driver) {
		super(driver);
	}

	boolean flag = false;
	boolean flag1 = false;
	boolean titleflag = false;
	boolean vendorflag = false;
	boolean categoryflag = false;
	boolean cashflag = false;
	boolean amountflag = false;
	public static Logger logger = Logger.getLogger(EditExpensePage.class);

	/* Web elements */

	By ExpensesTab = By.xpath(".//*[@id='top-menu']//a[contains(.,'Expenses')]");
	By listExpenseLink = By.xpath(".//*[@id='top-menu']//a[contains(.,'List of Expenses')]");
	By vendorNameTextField = By.xpath("//input[@name='new_vendor[]']");
	By VendorDropdown = By.xpath("//select[@name='vendor[]']");
	By CategoryDropdown = By.xpath("//select[@name='category[]']");
	By NotesTextarea = By.xpath("//textarea[@name='expense_notes[]']");
	By Amount = By.xpath("//input[@name='amount[]']");
	By CashDropdown = By.xpath("//select[@name='payment_source[]']");
	By SaveButton = By.id("saveBtn");
	By successDialog=By.xpath("//div[@class='alert alert-success alert-dismissable']");
	By errorDialog=By.xpath("//div[@class='alert alert-danger alert-dismissable']");
	public static String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testDataSheet.xlsx";

	public void clickOnListExpense() throws Exception {
		try {
			flag = isElementPresent(ExpensesTab);
			if (flag) {
				logger.info("New Expense tab is displayed");
				WebElement expTab = driver.findElement(ExpensesTab);
				WebElement listExpenselink = driver.findElement(listExpenseLink);
				Actions act = new Actions(driver);
				act.moveToElement(expTab).click(expTab).click(listExpenselink).doubleClick().build().perform();
				AynaxUtil.explicitWait(3000);
				act.click().build().perform();
				Assert.assertTrue(flag, "Expense link is not displayed");
				isTitleDisplayed();
				AynaxUtil.explicitWait(3000);

			} else {
				logger.info("New Expense tab is not displayed");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new Exception("Expense tab is not displayed::"+e.getLocalizedMessage());
		}
	}

	public void clickOnExpenseLink1() throws Exception {
		try {
			
			String vendorName = getValFromExcel(3, 2);
			
			By expenseLink1=By.xpath("//td[a[contains(.,'" +vendorName+ "')]]/preceding-sibling::td[1]/a");

			setElement(expenseLink1).click();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void clickOnExpenseLink2() throws Exception {
		try {
			
			String vendorName = getValFromExcel(4, 2);
			
			By expenseLink2=By.xpath("//td[a[contains(.,'" +vendorName+ "')]]/preceding-sibling::td[1]/a");

			setElement(expenseLink2).click();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	/*public void selectVendorName1() throws Exception {
		try {
			vendorflag = isElementPresent(VendorDropdown);
			if (vendorflag) {
				System.out.println("Vendor dropdown is displayed ");
				 String selectName = getValFromExcel(2, 2);

				selectDropDown(VendorDropdown, selectName);
				Assert.assertTrue(vendorflag, "New Vendor dropdown is not displayed");

			} else {

				System.out.println("New Expense tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	public void selectCategory() throws Exception {
		try {
			categoryflag = isElementPresent(CategoryDropdown);
			if (categoryflag) {
				System.out.println("Category dropdown is displayed");
				selectDropDown(CategoryDropdown, "Employee benefits");
				Assert.assertTrue(categoryflag, " Category dropdown is not displayed");

			} else {

				System.out.println("New Expense tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectCash() throws Exception {
		try {
			cashflag = isElementPresent(CashDropdown);
			if (cashflag) {
				System.out.println("Cash dropdown is displayed");
				selectDropDown(CashDropdown, "Cash");
				Assert.assertTrue(cashflag, " Cash dropdown is not displayed");

			} else {

				System.out.println("New Expense tab is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void enterAmont(String amount) throws Exception {
		try {
			amountflag = isElementPresent(Amount);
			if (amountflag) {
				System.out.println("Amount textarea is displayed");
				clearAndEnterValueInTextBox(Amount, amount);
				//setElement(Amount).sendKeys(amount);
				Assert.assertTrue(amountflag, " Amount is not displayed");

			} else {

				System.out.println("Amount element is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void enterNotes(String notes) throws Exception {
		try {
				clearAndEnterValueInTextBox(NotesTextarea, notes);
				Assert.assertTrue(amountflag, " Amount is not displayed");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickSave() throws Exception {
		if (isElementPresent(SaveButton)) {
			setElement(SaveButton).click();
		}
	}

	

	public void editExpense(String amount, String notes) throws Exception {
		try {
			
			selectCategory();
			selectCash();
			enterAmont(amount);
			enterNotes(notes);
			clickSave();
			AynaxUtil.explicitWait(3000);

		} catch (Exception e) {
			throw new Exception("New Expense link is not present in Expense page::");
		}
		// return new LoginPage(driver);
	}

	public boolean isTitleDisplayed() {

		getPageTitle();
		return titleflag;
	}
	public boolean isResultPageDisplayed() throws Exception
	{
		try 
		{
			flag1=isElementPresent(successDialog);
			if (flag1) 
			{
				logger.info("Success page of Expense creation is displayed");
			String expectedtitle = getPageTitle();
			logger.info("Title is "+expectedtitle);
			Assert.assertTrue(expectedtitle.contains("List of Expenses :: Aynax.com"));
			String text = getText(successDialog);
			logger.info("Success text"+text);
			Assert.assertTrue(text.contains("Expense successfully saved!"));
			
			}			
			else
			{
				logger.info("Error page of Expense creation is displayed");
				String expectedtitle = getPageTitle();
				Assert.assertTrue(expectedtitle.startsWith("Edit Expense:: "));
				String text = getText(errorDialog);
				logger.info("The error text is" + text);
				Assert.assertTrue(text.startsWith("×"));
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("New Vendor page is displayed::"+isResultPageDisplayed()+e.getLocalizedMessage());
		}
		return flag1;
	}
	public static String getValFromExcel(int row, int col) throws Exception {

		ExcelutilObject.setExcelFile(excelPath, "VendorData");
		return ExcelutilObject.getCellData(row, col);
	}

}