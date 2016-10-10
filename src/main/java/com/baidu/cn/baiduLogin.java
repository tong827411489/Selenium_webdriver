package com.baidu.cn;

import org.openqa.selenium.WebDriver;

import cn.sele.DBOp;
import cn.sele.Do;
import cn.sele.Wait;
import cn.sele.pageBase;

public class baiduLogin{
	
	private WebDriver driver;
	private Do du;
	private Wait wait;
	private DBOp db;
	private pageBase pb;
	
	public baiduLogin(WebDriver driver) {
		this.driver = driver;
		pb = new pageBase(driver, "baiduLogin", "\\tools\\baiduLogin.sqlite");
	}
	
	public void Login(){
//		wait.waitForElementPresent(waitElement("Login"));
		pb.getLoc("Login").click();
	}
	
	public baiduLogin account(String account){
		wait.waitForElementPresent(pb.waitElement("account"));
		wait.waitFor(2000);
		pb.getLoc("account").sendKeys(account);;
		return this;
	}
	
	public baiduLogin password(String password){
		pb.getLoc("password").sendKeys(password);;
		return this;
	}
	
	public baiduLogin submit(){
		pb.getLoc("submit");
		db.close();
		return this;
	}
}
