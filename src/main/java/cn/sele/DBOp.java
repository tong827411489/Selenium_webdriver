package cn.sele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOp{
	
	private Statement stat = null;
	private ResultSet rsp = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
	
	public void conn(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\tools\\DBLogin.sqlite");
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public String getLocatorXpath(String locatorname){
		String Xpath = null;
		try {
			rsp = stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsp.next()) {
				Xpath = rsp.getString("Xpath");	
			}
			rsp.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Xpath;
	}
	
	public String getlocatorCss(String locatorname){
		String Css = null;
		try {
			rsp = stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsp.next()) {
				Css = rsp.getString("Css");
			}
			rsp.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Css;
	}
	
	public static void main(String[] args){
		DBOp b = new DBOp("LoginPage");
		b.conn();
		System.out.println(b.getLocatorXpath("Login"));
	}
}
