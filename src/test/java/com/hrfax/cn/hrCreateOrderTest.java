package com.hrfax.cn;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.sele.Browsers;
import cn.sele.BrowsersType;
import cn.sele.Wait;
import page.hrCreateOder;
import page.hrLogin;

public class hrCreateOrderTest{
	
	private WebDriver driver;
	private hrLogin login;
	private hrCreateOder createOder;
	private Wait wait;
	private String projectpath = System.getProperty("user.dir"); 
	private String name;
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		login = new hrLogin(driver);
		createOder = new hrCreateOder(driver);
		wait = new Wait(driver);
		name = "张三";
	}
	
	/**
	 * 创建订单
	 */
	@Test
	public void test(){
		driver.get("http://192.168.0.186:9092");
//		login.Login();
//		login.account("jqrjbr1");
//		login.password("111111");
//		login.submit();
//		createOder.newOder();
//		createOder.photo1(projectpath+"/tools/111111.jpg");
//		createOder.name(name).oppositeID("33012219921121"+wait.getRandomNumber(1)).phone("1826821"+wait.getRandomNumber(1)).Preservation();
//		wait.waitFor(5000);
//		createOder.photo2(projectpath+"/tools/11111.jpg");
//		createOder.photo3(projectpath+"/tools/11111.jpg");
//		createOder.photo4(projectpath+"/tools/11111.jpg");
//		wait.waitFor(2000);
//		createOder.PerfectInformation();
//		
//		createOder.unmarried().NoHouse().PrivateBrand().legalPersonNo().newCar();
//		createOder.selctFormdb("浙江省", "直属");
//		createOder.formadb(account, password);
		
//		createOder.nextPage();
//		createOder.selectBank();
//		wait.waitFor(2000);
		createOder.totalBank("其他银行").determine();
//		createOder.totalBank("中国工商银行浙江省分行");
//		createOder.areaBank("杭州");
//		createOder.branchBank("城战支行");
		createOder.query("正常", "1", "2", "1", "", "征信正常，可以走").determine();
		createOder.MaterialManagement();
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}
