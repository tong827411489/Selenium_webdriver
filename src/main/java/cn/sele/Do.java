package cn.sele;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Do {
	
	private WebDriver driver;
	private Wait wait;
	private WebElement we = null;
	
	public Do(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement what(String locatename){
		try {
			we = driver.findElement(By.xpath(locatename));
		} catch (Exception e) {
			e.getMessage();
		}
		return we;
	}
	
	public List<WebElement> whats(String locatename){
		return driver.findElements(By.xpath(locatename));
	}
	
	public void waitForElementPresent(String locatename){
		wait.waitForElementPresent(locatename);
	}
	
	
	
//	public WebElement getWebElement(String wm,String accountname){
//		return do.what(String.format(wm, accountname));
//	}
	
}
