package test;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generics.BaseTest;
import pom.HomePage;
import pom.LoginPage;

@Listeners(generics.Screenshot.class)
public class ActitimeLoginLogout extends BaseTest
{
	@Test
	public void login() throws InterruptedException, IOException
	{
		LoginPage login=new LoginPage(driver);
		login.loginMethod();
		
		HomePage home=new HomePage(driver);
		home.logoutMethod();
	}
}