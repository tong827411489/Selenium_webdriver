package cn.sele;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageBase {
	
	private WebDriver driver;
	private Do du;
	private DBOp db;
	private Map<String,String> sf = new HashMap();
	
	public pageBase(WebDriver driver,String name,String path){
		this.driver = driver;
		du = new Do(driver);
		db = new DBOp(name);
		db.con(path);
	}
	
	public WebElement getLoc(String loc){
		WebElement we = null;
		if (db.getLocatorXpath(loc) != null&&!db.getLocatorXpath(loc).equals("")) {
			try {
				we = du.what(db.getLocatorXpath(loc));
			} catch (Exception e) {
				if (db.getlocatorCss(loc) != null&&!db.getlocatorCss(loc).equals("")) {
					we = du.what(db.getlocatorCss(loc));
				}
			}
		}else{
			we = du.what(db.getlocatorCss(loc));
		}
		return we;
	}
	
	public String getValueLoc(String loc){
		sf.clear();
		
		if (db.getLocatorXpath(loc) != null&&!db.getLocatorXpath(loc).equals("")) {
			sf.put(loc, db.getLocatorXpath(loc));
		}else{
			sf.put(loc, db.getlocatorCss(loc));
		}
		
		return sf.get(loc);
	}
	
	public String waitElement(String loc){
		String we;
		if (db.getLocatorXpath(loc) !=null&&!db.getLocatorXpath(loc).equals("")){
			we = db.getLocatorXpath(loc);
			return we;
		}else{
			we = db.getlocatorCss(loc);
			return we;
		}
		
	}
}
