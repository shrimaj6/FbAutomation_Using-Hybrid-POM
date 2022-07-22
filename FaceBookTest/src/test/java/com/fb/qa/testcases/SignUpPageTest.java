package com.fb.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.SignUpPage;
import com.fb.qa.pages.GroupsPage;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

public class SignUpPageTest extends TestBase{

	
//	LoginPage loginPage;
//    HomePage homePage;
//    GroupsPage groupPage;
//    CreateNewAccount createNewAccount;
//    public CreateNewAccTest() {
//        super();
//    }
//
//    @BeforeMethod
//    public void setUp() {
//        initialization();
//        loginPage = new LoginPage();
//        groupPage = new GroupsPage();
//        //createNewAccount = new CreateNewAccount();
//        //createNewAccount = new CreateNewAccount();
//        //homePage = loginPage.login(prop.getProperty("EmailAddress"), prop.getProperty("password"));
//        //createNewAccount = homePage.clickOnCreateNewAccount();
//    }
//
//
//    @Test(priority = 1)
//    public void verifyHomePageTitleTest() {
//        String homePageTitle = homePage.verifyHomePageTitle();
//        Assert.assertEquals(homePageTitle, "Facebook – log in or sign up", "Home Page is Incorrect");
//    }
//
//    @Test(priority = 2)
//    public void validateSignUpPageTitleTest() {
//    	createNewAccount.validateSignUpPageTitle();
//    }
////
//    @Test(priority = 3)
//    public void ClickOnCreateNewAccountTestLink(){
//        createNewAccount.ValidateCreateNewAccount("ajay", "lad", "ajaylad112211@gmail.com", "ajaylad112211@gmail.com", "qwerty@111", 01, "jan", 1997, "male");
//    }
//
//
//
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }
	
	SignUpPage signUpPage;
	LoginPage loginPage;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void signUpPageTitleTest() {
		String title = signUpPage.validateSignUpPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void SignUpTest() {
		loginPage = signUpPage.signUp(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("email"), prop.getProperty("verifyEmail"), prop.getProperty("password"),
				prop.getProperty("birthDay"), prop.getProperty("birthMonth"), prop.getProperty("birthYear"),
				prop.getProperty("gender"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

