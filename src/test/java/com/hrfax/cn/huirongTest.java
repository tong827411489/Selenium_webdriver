package com.hrfax.cn;

import locator.HRlocator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.sele.Browsers;
import cn.sele.BrowsersType;
import cn.sele.Wait;
import page.Registerpage;


public class huirongTest {
	
	private WebDriver driver;
	private Registerpage re;
	private Wait wait;
	
	//运行前修改两个参数
	private String CompanyName = "环球测试五";
	private String requestName = "李四个";
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
		re = new Registerpage(driver);
	}
	
	/*
	 * 注册流程
	 * 验证是否注册成功
	 */
	@Test
	public void test1(){
		
		
		driver.get("http://192.168.0.186:9092");
		
		re.hrregister();
		re.hrnextpage();
		
		re.setCompanyName(CompanyName);
		re.selectProvince("浙江省");
		re.selectCity("杭州市");
		re.selectArea("桐庐县");
		re.requestName(requestName);
		re.imgAuthCode("1111");
		re.phone("1826829"+re.getRandomNumber(1));
		re.phoneAuthCode("0987654321");
		re.checkpassword("111111q");
		re.Registerpage();
		re.companyLicencs("D:/11111.jpg");
		wait.waitFor(1000);
		re.submit();
		re.Determine();
		re.Determine();
		re.success();
		Assert.assertEquals(re.getWebElement(HRlocator.companyname1, CompanyName).isDisplayed(), true);
		wait.waitFor(5000);
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
