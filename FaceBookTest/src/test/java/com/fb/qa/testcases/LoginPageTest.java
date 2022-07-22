package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import com.fb.qa.util.testutil;

import bsh.util.Util;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import dev.failsafe.internal.util.Assert;
import org.testng.Assert;
import org.apache.log4j.Logger;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	testutil testutil;
	String sheetName = "Sheet1";

	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		log.info("******** Starting test cases execution  *********");
		initialization();
		loginPage = new LoginPage();
	}

//	@Test(priority = 1, description = "verifying the login page title test")
//	@Severity(SeverityLevel.NORMAL)
//	@Description("Test case Desc: Verify loginpage title test")
//	@Story("Story Name: To check login page title")
//	public void VerifyLoginPageTitle() {
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "Facebook – log in or sign up");
//		}
	@Test(priority = 1, description = "verifying fbLogo test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case Desc: Verify fbLogo test on Login page")
	@Story("Story Name: To check fbLogo test")
	public void fbLogoTest() {
		boolean flag = loginPage.validateFbImg();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2, description = "verifying the loginTest on Login page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case Desc: Verify loginTest on Login page")
	@Story("Story Name: To check loginPage test")
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getLoginTestData() throws InvalidFormatException {
		Object data[][] = testutil.getTestData(sheetName);
		return data;
	}

	// using Data driven approch
	@Test(priority = 3, dataProvider = "getLoginTestData", description = "verifying multiple login using dataprovider test on login page")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test case Desc: Verify multiple loginTest on Login page")
	@Story("Story Name: To check multiple loginPage test")
	public void multipleLoginTest(String userName, String password) throws InterruptedException {
		homePage = loginPage.loginMultipleAccounts(userName, password);
		Thread.sleep(3000);
		log.info("login successful with username: " + userName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
