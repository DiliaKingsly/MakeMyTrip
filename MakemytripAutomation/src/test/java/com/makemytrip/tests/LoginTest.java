package com.makemytrip.tests;
import org.testng.annotations.Test;

import com.makemytrip.helpers.BrowserLaunch;
import com.makemytrip.pages.LoginPage;

public class LoginTest extends BrowserLaunch {
	
	@Test
	public void clickLogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(4000);
		lp.clickSignIn();
		lp.login();
		lp.search();
	}

}
