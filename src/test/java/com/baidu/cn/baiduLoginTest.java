package com.baidu.cn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.sele.Browsers;
import cn.sele.BrowsersType;
import cn.sele.Wait;

public class baiduLoginTest{
	
	private WebDriver driver;
	private baiduLogin bl;
	private Wait wait;
	
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		bl = new baiduLogin(driver);
		wait = new Wait(driver);
	}
	
	@Test
	public void test(){
		driver.get("http://www.baidu.com");
		bl.Login();
		bl.account("18268207153").password("827411489").submit();
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
