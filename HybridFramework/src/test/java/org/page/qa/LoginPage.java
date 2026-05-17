package org.page.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id = "Email")
	private WebElement userName;
	
	@FindBy(name = "Password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit'and @value= 'Log in']")
	private WebElement loginBtn;
	
	public void login (String un,String pwd) {
		
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
