package page;

import locator.HrLogin;

import org.openqa.selenium.WebDriver;

import cn.sele.Do;
import cn.sele.Wait;

public class hrLogin {
	
	private WebDriver driver;
	private Do du;
	private Wait wait;
	
	public hrLogin(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		wait = new Wait(driver);
	}
	
	public void Login(){
		du.what(HrLogin.Login).click();
	}
	
	public hrLogin account(String account){
		du.what(HrLogin.account).sendKeys(account);
		return this;
	}
	
	public hrLogin password(String password){
		du.what(HrLogin.password).sendKeys(password);
		return this;
	}
	
	public void submit(){
		du.what(HrLogin.submit).click();
	}
}
