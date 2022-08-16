package appPages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import reusable.BaseClass;
import utilities.SeleniumActions;

public class Login extends BaseClass {

	SeleniumActions Actions = new SeleniumActions();
	BaseClass Base = new BaseClass();

	public void AppLoginURL() throws InterruptedException, IOException, AWTException {

		Base.ConfigDataRead();

		HashMap<String, String> ConfigData = ConfigDataRead();

		driver.get(ConfigData.get("AppLoginURL"));

	}
	
	public void WaitLoginToYourAccount() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Actions.ExplicitWait(20, Locator.get("LoginYourAccount"), "visibilityOfElementLocated");
	}
	
	public boolean LoginToYourAccount() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Boolean exist = Actions.IsExists(Locator.get("LoginYourAccount"));
		
		return exist;
	}
	
	

	public void WaitUsername() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Actions.ExplicitWait(20, Locator.get("Username"), "visibilityOfElementLocated");
	}

	public void UserName() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Base.ConfigDataRead();

		HashMap<String, String> ConfigData = ConfigDataRead();

		Actions.SendKeys(Locator.get("Username"), ConfigData.get("Username"));

	}

	public void WaitPassword() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Actions.ExplicitWait(20, Locator.get("Password"), "visibilityOfElementLocated");
	}

	public void Password() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Base.ConfigDataRead();

		HashMap<String, String> ConfigData = ConfigDataRead();

		Actions.SendKeys(Locator.get("Password"), ConfigData.get("Password"));

	}

	public void WaitLoginButton() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Actions.ExplicitWait(20, Locator.get("Password"), "visibilityOfElementLocated");
	}

	public void LoginButton() throws InterruptedException, IOException, AWTException {

		Base.LocatorDataRead();

		HashMap<String, String> Locator = LocatorDataRead();

		Actions.ActionClass(Locator.get("LoginButton"), "click");


	}

}
