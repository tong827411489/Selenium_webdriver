package com.hrfax.cn;

import locator.HRlocator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.sele.Browsers;
import cn.sele.BrowsersType;
import cn.sele.DBmysql;
import cn.sele.Wait;
import page.Registerpage;


public class hrrEgisterTest {
	
	private WebDriver driver;
	private Registerpage re;
	private Wait wait;
	private DBmysql db; 
	private String path = System.getProperty("user.dir");
	
	private String CompanyName = "环球测试六";
	private String requestName = "李三三";
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
		re = new Registerpage(driver);
		db = new DBmysql("//192.168.0.186:3306/loan", "root", "abc#123");
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
		re.companyLicencs(path+"\\tools\\111111.jpg");
		wait.waitFor(1000);
		re.submit();
		re.Determine();
		re.Determine();
		re.success();
		//断言是否跳转到注册成功页面
		Assert.assertEquals(re.getWebElement(HRlocator.companyname1, CompanyName).isDisplayed(), true);
		wait.waitFor(5000);
	}
	
	/**
	 * 关闭浏览器
	 * 删除数据库中的值，保证脚本不用更改参数
	 */
	@AfterClass
	public void end(){
		String company_name = null;
		driver.quit();
		db.mysqlOpen();
		company_name = db.selectSQL("SELECT p.`company_name` FROM company p WHERE p.`request_name`='"+requestName+"'","company_name");
		Assert.assertEquals(company_name.equals(CompanyName), true);
		db.deleteMysql("DELETE FROM company WHERE company_name = '"+CompanyName+"'");
		db.deleteMysql("DELETE FROM pms_user WHERE USER_ACCOUNT = (SELECT phone FROM company WHERE company_name = '"+CompanyName+"')");
		db.close();
	}
}
