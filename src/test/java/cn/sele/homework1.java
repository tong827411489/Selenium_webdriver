package cn.sele;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class homework1 {
	private WebDriver driver;
	private Wait wait;
	
	@BeforeClass
	public void before(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wait = new Wait(driver);
		driver.get("http://www.126.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//进入iframe
		driver.switchTo().frame("x-URS-iframe");
		//帐号密码填写登录
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='邮箱帐号或手机号']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='邮箱帐号或手机号']")).sendKeys("FireflyAutomation");
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='密码']")).clear();
		driver.findElement(By.xpath("//form[@id='login-form']/descendant::input[@data-placeholder='密码']")).sendKeys("Firefly");
		wait.waitFor(1000);
		driver.findElement(By.xpath("//a[@id='dologin']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='cnt-box-parent']/descendant::a[text()='继续登录']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
	}
	

	
	//查看未读
	@Test
	public void test2(){
		wait.waitForElementPresent("//div[@id='dvNavTree']/descendant::span[text()='收件箱']");
		Actions actions = new Actions(driver);
		//右击收件箱
		actions.contextClick(driver.findElement(By.xpath("//div[@id='dvNavTree']/descendant::span[text()='收件箱']"))).build().perform();
		
		driver.findElement(By.xpath("//div[contains(@style,'visible')]/descendant::span[text()='查看未读']")).click();
		String unlook = driver.findElement(By.xpath("//div[@id='dvContainer']/descendant::h1[text()='未读']")).getText();
		Assert.assertEquals(unlook.equals("未读"), true);
	}
	
	@AfterClass
	public void end(){
		driver.quit();
	}
}

