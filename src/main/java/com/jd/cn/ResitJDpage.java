package com.jd.cn;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ResitJDpage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='免费注册']")
	private WebElement mian;
	
	@FindBy(xpath = "//input[@id='form-account']")
	private WebElement userId;
	
	@FindBys(@FindBy(xpath = "//input[@id='form-pwd']|//input[@id='form-equalTopwd']"))
	private List<WebElement> passWord;
	
	public ResitJDpage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ResitJDpage zc(){
		mian.click();
		return this;
	}
	
	public ResitJDpage setUserId(String userid){
		userId.sendKeys(userid);
		return this;
	}
	
	public void setPassWord(String pass){
		for(WebElement we: passWord){
			we.sendKeys(pass);
		}
	}
}
