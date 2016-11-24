package page;

import java.util.List;

import locator.HRlocator;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cn.sele.Do;
import cn.sele.Wait;

public class Registerpage {
	
	private WebDriver driver;
	private Do du;
	private Select select;
	private Wait wait;
	
	public Registerpage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		wait = new Wait(driver);
	}
	
	public void hrregister(){
		wait.waitForElementPresent(HRlocator.hrregister);
		du.what(HRlocator.hrregister).click();
	}
	
	public void hrnextpage(){
		du.what(HRlocator.hrnextpage).click();
	}
	
	public Registerpage setCompanyName(String companyname){
		du.what(HRlocator.companyname).sendKeys(companyname);
		return this;
	}
	
	public Registerpage selectProvince(String province){
		select = new Select(du.what(HRlocator.selectprovince));
		select.selectByVisibleText(province);
		return this;
	}
	
	public Registerpage selectCity(String city){
		select = new Select(du.what(HRlocator.selectcity));
		select.selectByVisibleText(city);
		return this;
	}
	
	public Registerpage selectArea(String area){
		select = new Select(du.what(HRlocator.selectarea));
		select.selectByVisibleText(area);
		return this;
	}
	
	public void requestName(String num){
		du.what(HRlocator.requestName).sendKeys(num);
	}
	
	public void imgAuthCode(String code){
		du.what(HRlocator.imgAuthCode).sendKeys(code);
	}
	
	public void phone(String num){
		du.what(HRlocator.phone).sendKeys(num);
	}
	
	public void phoneAuthCode(String code){
		du.what(HRlocator.phoneAuthCode).sendKeys(code);
	}
	
	public Registerpage checkpassword(String password){
		for(WebElement we:du.whats(HRlocator.checkpassword)){
			we.sendKeys(password);
		}
		return this;
	}
	
	public Registerpage Registerpage(){
		du.what(HRlocator.registernextpage).click();
		return this;
	} 
	
	public Registerpage companyLicencs(String liences){
		du.what(HRlocator.companyLicencs).sendKeys(liences);
		return this;
	}
	
	public void submit(){
		du.what(HRlocator.submit).click();
	}
	
	public Registerpage Determine(){
		du.what(HRlocator.Determine).click();
		return this;
	}
	
	public WebElement getWebElement(String wm,String companyname){
		return du.what(String.format(wm, companyname));
	}
	
	public void success(){
		wait.waitForElementPresent(HRlocator.success);
	}
	
	/*
	 * 4位随机数变化
	 */
	public  int getRandomNumber(int i) {
		return (int) ((Math.random() * 10000));
		}
}
