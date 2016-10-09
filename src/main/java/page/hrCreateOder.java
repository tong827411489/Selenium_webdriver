package page;

import locator.HRCreateOrder;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cn.sele.Do;
import cn.sele.Wait;

public class hrCreateOder {
	
	private WebDriver driver;
	private Wait wait;
	private Do du;
	
	
	public hrCreateOder(WebDriver driver){
		this.driver = driver;
		wait = new Wait(driver);
		du = new Do(driver);
	}
	
	public hrCreateOder close(){
		if (wait.doesWebElementExist(HRCreateOrder.close)) {
			du.what(HRCreateOrder.close).click();
		}
		return this;
	}
	
	public void newOder(){
		wait.waitForElementPresent(HRCreateOrder.newOder);
		wait.waitFor(1000);
		du.what(HRCreateOrder.newOder).click();
	}
	
	public void photo1(String path){
		wait.waitForElementPresent(HRCreateOrder.photo1);
		du.what(HRCreateOrder.photo1).sendKeys(path);
	}
	
	public hrCreateOder name(String name){
		wait.waitFor(5000);
		wait.js("document.getElementsByClassName('ngdialog-close')[0].click();");
		du.what(HRCreateOrder.name).sendKeys(name);
		return this;
	}
	
	public hrCreateOder oppositeID(String oppositeID){
		du.what(HRCreateOrder.oppositeID).sendKeys(oppositeID);
		return this;
	}
	
	public hrCreateOder phone(String phone){
		du.what(HRCreateOrder.phone).sendKeys(phone);
		return this;
	}
	
	public void Preservation(){
		du.what(HRCreateOrder.Preservation).click();
		wait.waitFor(3000);
		wait.js("document.getElementsByClassName('ngdialog-close')[0].click();");
	}
	
	public void photo2(String photo1){
		du.what(HRCreateOrder.photo2).sendKeys(photo1);
	}
	
	public void photo3(String photo1){
		du.what(HRCreateOrder.photo3).sendKeys(photo1);
	}
	
	public void photo4(String photo1){
		du.what(HRCreateOrder.photo4).sendKeys(photo1);
	}
	
	public void PerfectInformation(){
		du.what(HRCreateOrder.PerfectInformation).click();
	}
	
	public hrCreateOder unmarried(){
		wait.waitForElementPresent(HRCreateOrder.unmarried);
		du.what(HRCreateOrder.unmarried).click();
		return this;
	}
	
	public hrCreateOder NoHouse(){
		du.what(HRCreateOrder.NoHouse).click();
		return this;
	}
	
	public hrCreateOder PrivateBrand(){
		du.what(HRCreateOrder.PrivateBrand).click();
		return this;
	}
	
	public hrCreateOder legalPersonNo(){
		du.what(HRCreateOrder.legalPersonNo).click();
		return this;
	}
	
	public hrCreateOder newCar(){
		du.what(HRCreateOrder.newcar).click();
		return this;
	}
	
	public hrCreateOder selctFormdb(String city,String area){
		Select City = new Select(du.what(HRCreateOrder.city));
		City.selectByVisibleText(city);
		Select Area = new Select(du.what(HRCreateOrder.area));
		Area.selectByVisibleText(area);
		return this;
	}
	
	public hrCreateOder formadb(String account,String password){
		du.what(HRCreateOrder.formdbAccount).sendKeys(account);
		du.what(HRCreateOrder.formdbPassword).sendKeys(password);
		return this;
	}
	
	public void nextPage(){
		du.what(HRCreateOrder.nextPage).click();
	}
	
	public void selectBank(){
		du.what(HRCreateOrder.selectBank).click();
	}
	
	public hrCreateOder totalBank(String totalBank){
		wait.js("document.getElementsByClassName('bankselect-panel')[0];");
		Select s = new Select(du.what(HRCreateOrder.totalBank));
		s.selectByVisibleText("其它银行");
		return this;
	}
	
	public hrCreateOder areaBank(String areaBank){
		Select total = new Select(du.what(HRCreateOrder.areaBank));
		total.selectByVisibleText(areaBank);
		return this;
	}
	
	public hrCreateOder branchBank(String branchBank){
		Select total = new Select(du.what(HRCreateOrder.branchBank));
		total.selectByVisibleText(branchBank);
		return this;
	}
	
	public hrCreateOder determine(){
		du.what(HRCreateOrder.determine).click();
		return this;
	}
	
	public hrCreateOder query(String grade,String HistoricalLoan,String HistoryCreditCard,String amortized,String unCleared,String Remarks){
		du.what(HRCreateOrder.query).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String js1 = "document.getElementsByClassName('ngdialog-content')[0];";
		js.executeScript(js1);
		Select grade1 = new Select(du.what(HRCreateOrder.grade));
		grade1.selectByVisibleText(grade);
		du.what(HRCreateOrder.HistoricalLoan).sendKeys(HistoricalLoan);
		du.what(HRCreateOrder.HistoryCreditCard).sendKeys(HistoryCreditCard);
		du.what(HRCreateOrder.amortized).sendKeys(amortized);
		du.what(HRCreateOrder.unCleared).sendKeys(unCleared);
		du.what(HRCreateOrder.Remarks).sendKeys(Remarks);
		return this;
	}
	
	public void MaterialManagement(){
		wait.waitForElementPresent(HRCreateOrder.MaterialManagement);
		du.what(HRCreateOrder.MaterialManagement).click();
	}
	
}
