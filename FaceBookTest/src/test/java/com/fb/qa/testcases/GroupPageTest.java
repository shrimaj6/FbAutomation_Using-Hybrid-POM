package com.fb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.GroupsPage;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

public class GroupPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
    //NotificationsPage notificationPage;
    GroupsPage groupPage;
	public GroupPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		groupPage = new GroupsPage();
	    homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	 
	
	@Test(priority = 1)
	public void verifyGrouplabelTest() {
	Assert.assertTrue(groupPage.verifyGrouplabel());	
	}
	
	@Test(priority = 2)
	public void VerifyClickOnGroupLink() {
		groupPage = homePage.ClickOnGroupsLink();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
