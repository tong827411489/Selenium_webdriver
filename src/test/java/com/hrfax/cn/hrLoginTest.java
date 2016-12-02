package com.hrfax.cn;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.sele.Browsers;
import cn.sele.BrowsersType;
import cn.sele.Wait;
import page.LoginPage;

public class hrLoginTest {
	
	private WebDriver driver;
	private LoginPage lg;
	private Wait wait;
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
		lg = new LoginPage(driver);
	}
	
	/**
	 * 登录帐号及退出测试
	 */
	@Test
	public void LoginTest(){
		driver.get("http://192.168.0.186:9092");
		
		lg.Login();
		lg.account("zrjbr1", "111111").submit();
		lg.warning();
		lg.showName().loginOut();
		wait.waitFor(2000);
		Assert.assertEquals(lg.getElement().isDisplayed(), true);
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
