package page;

import locator.HRlocator;
import locator.HrLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cn.sele.Do;
import cn.sele.Wait;

public class LoginPage {
		
	private WebDriver driver;
	private Do du;
	private Wait wait;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		wait = new Wait(driver);
	}
	
	public void Login(){
		wait.waitForElementPresent(HrLogin.Login);
		du.what(HrLogin.Login).click();
	}
	
	public LoginPage account(String account,String password){
		wait.waitForElementPresent(HrLogin.account);
		du.what(HrLogin.account).clear();
		du.what(HrLogin.account).sendKeys(account);
		du.what(HrLogin.password).clear();
		du.what(HrLogin.password).sendKeys(password);
		return this;
	}
	
	public void submit(){
		du.what(HrLogin.submit).click();
	}
	
	public void warning(){
		wait.waitForElementPresent(HrLogin.warning);
		du.what(HrLogin.warning).click();
		wait.waitForElementPresent(HrLogin.warNing);
		du.what(HrLogin.warNing).click();

	}
	
	public LoginPage showName(){
		wait.waitForElementPresent(HrLogin.showName);
		du.what(HrLogin.showName).click();
		return this;
	}
	
	public void loginOut(){
		wait.waitForElementPresent(HrLogin.loginOut);
		du.what(HrLogin.loginOut).click();
	}
	
	public WebElement getElement(){
		return du.what(HrLogin.account);
	}
}	
