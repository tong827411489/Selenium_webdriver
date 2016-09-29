package cn.sele;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import locator.HRCreateOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	private WebDriver driver;
	private int timeout = 10;
	

	public Wait(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementPresent(String locator){
		try {
			(new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void waitForElementIsEnable(String locator){
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public void waitFor(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitManage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public boolean doesWebElementExist(String xpath){
		boolean flag = false;
		try {
//			waitFor(2000);
			driver.findElement(By.xpath(xpath));
			 flag = true;
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
		return flag;
	}
	
	public  int getRandomNumber(int i) {
		return (int) ((Math.random() * 10000));
		}
	
	//处理单个非alert弹窗
	public boolean testNewWindow(WebDriver driver){
	    try{
	        //定位窗口
	        driver.switchTo().window(driver.getWindowHandles().iterator().next());
	        return true;
	    }catch(Exception e){
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
}
