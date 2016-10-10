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
	private Connection conn;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
	
	public void con(String n){
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+n);
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
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Css;
	}
	
	public void close(){
		try {
			rsp.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args){
		DBOp b = new DBOp("baiduLogin");
		b.con("\\tools\\baiduLogin.sqlite");
		System.out.println(b.getLocatorXpath("Login"));
		b.close();
	}
}
