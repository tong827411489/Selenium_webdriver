package com.jdtest.cn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jd.cn.JDHomePage;
import com.jd.cn.ResitJDpage;

import cn.sele.Browsers;
import cn.sele.BrowsersType;
import cn.sele.Wait;

public class testHomePage {
	
	private WebDriver driver;
	private Wait wait;
	
	@BeforeClass
	public void before(){
		
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
	}
	
	@Test
	public void jdpage(){
		
		
		JDHomePage jdhomepage = new JDHomePage(driver);
		ResitJDpage jdpage = new ResitJDpage(driver);
		
		
		jdhomepage.homePage("http://www.jd.com/");
		wait.waitForElementPresent("//a[text()='免费注册']");
		jdpage.zc();
		wait.waitForElementPresent("//span[text()='企业用户注册']");
		jdpage.setUserId("hfsah113");
		jdpage.setPassWord("admin");
		wait.waitFor(5000);
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
