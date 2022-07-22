package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(HomePageTest.class);
    //NotificationsPage notificationPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//notificationPage = new NotificationsPage();
	    homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
	  String homePageTitle = homePage.verifyHomePageTitle();
	  Assert.assertEquals(homePageTitle, "Facebook");
	}
	
	@Test(priority = 2)
	public void verifyUsernameTest() {
	Assert.assertTrue(homePage.verifyUsernameLabel());	
	log.info("verify username test: ");
		
	}
	
//	@Test
//	public void verifyUploadPicTest() throws IOException {
//		homePage.clickOnAddPictureLink();
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	

}
