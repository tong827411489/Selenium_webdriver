package com.jd.cn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JDHomePage {
	
	private WebDriver driver;
	
	public JDHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void homePage(String url){
		driver.get(url);
	}
}
