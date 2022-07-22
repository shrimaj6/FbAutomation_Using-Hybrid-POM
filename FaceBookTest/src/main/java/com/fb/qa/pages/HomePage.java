package com.fb.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Group conversations')]")
	WebElement groupconvLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Ajay M')]")
	WebElement usernamelabel;
	
	@FindBy(xpath = "//span[text()='Find Friends']")
	WebElement findFriendsLink;
	
	@FindBy(xpath = "//a[contains(@href,'/notifications/')]")
	WebElement NotificationsLink;
	
	@FindBy(xpath = "//a[contains(@href,'/groups/')]")
	WebElement groupsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Create New Account')]")
	WebElement createnewaccountbtn;
	
	@FindBy(xpath = "//span[text()='Add Picture']")
	WebElement addPicBtn;
	
	@FindBy(xpath = "//span[text()='Upload Photo']")
	WebElement uploadPhoto;
	
	
	
public HomePage() {
		
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
	     return driver.getTitle();
	    		 
	}
	
//	public boolean verifyUsernameLabel() {
//		 return usernamelabel.isDisplayed();
//	}
	
	public HomePage ClickOnFindFriendsLink() {
		findFriendsLink.click();
		return new HomePage();
	}
	
	
	public GroupsPage ClickOnGroupsLink() {
		groupsLink.click();
		return new GroupsPage();
	}
	

	public boolean verifyUsernameLabel() {
		  return usernamelabel.isDisplayed();
		
	}
	
	public void clickOnAddPictureLink() throws IOException
	{
		Actions action = new Actions(driver);
		action.moveToElement(addPicBtn).build().perform();
		//uploadPhoto.click();
		driver.findElement(By.xpath("//span[text()='Upload Photo']")).click();
		Runtime.getRuntime().exec("E:\\testing\\AutoIT\\fbdemo.exe");
		
		
	}
	
	

	
	
	
	
	
	 
}
