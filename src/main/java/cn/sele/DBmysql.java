package cn.sele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBmysql {
	
	private Connection con;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = null;
	private String user = null;
	private String password = null;
	private PreparedStatement ps;
	
	public DBmysql(String url,String user,String password){
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void mysqlOpen(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mysql:"+url, user, password);
			 if(!con.isClosed())
	                System.out.println("Succeeded connecting to the Database!");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectMysql(String sql){
		try {
//			Statement statement = con.createStatement();
			 ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			String name;
			
			while (res.next()) {
				name = res.getString(1);
				String name1 = res.getString(2);
				
//				name = res.getString("company_name");
				
				System.out.println(name+"\t"+name1 );
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateMysql(String sql){
		PreparedStatement prs;
		try {
			Statement statement = con.createStatement();
			prs = con.prepareStatement(sql);
			prs.executeUpdate();
			prs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		DBmysql db = new DBmysql("//192.168.0.186:3306/loan2", "root", "abc#123");
		db.mysqlOpen();
		db.selectMysql("select * from company where request_name = '李三三'");
	}
}
