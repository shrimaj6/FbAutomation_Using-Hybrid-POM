package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class GroupsPage extends TestBase{

	@FindBy(xpath = "//span[contains(text(),'Groups')]")
	WebElement groupLabel;
	
	public GroupsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyGrouplabel() {
		return groupLabel.isDisplayed();
	}
	
	public GroupsPage ClickOnGroupLink() {
		groupLabel.click();
		return new GroupsPage();
	}
	
	
}
