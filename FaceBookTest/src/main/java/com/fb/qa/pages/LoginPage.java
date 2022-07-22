package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;

import bsh.This;
import io.qameta.allure.Step;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(xpath = "//button[contains(@name,'login')]")
	WebElement login;
	
	@FindBy(xpath = "//a[contains(text(),'Create New Account')]")
	WebElement CreateNewAccBtnElement;
	
	@FindBy(xpath = "//img[contains(@class,'fb_logo _8ilh img')]")
	WebElement fbLogo;
	//Initilazing the page objects
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	//Actions
	@Step("getting login page title....")
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	@Step("verifying Fbimg is displayed step")
	public boolean validateFbImg() {
	return fbLogo.isDisplayed();
	}
	
	@Step("login with username: {0} and password: {1} step...")
	public HomePage login(String un,String pwd) {
		email.sendKeys(un);
		pass.sendKeys(pwd);
		login.click();
		
		return new HomePage();
		
	}
	
	public HomePage loginMultipleAccounts(String un, String pwd) {
	
		email.sendKeys(un);
        pass.sendKeys(pwd);
        login.submit();
        return new HomePage();
	}

			
	
	
	
	
	
}
