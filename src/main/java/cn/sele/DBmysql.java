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
	
	public void selectMysql(String sql,String name){
		try {
//			Statement statement = con.createStatement();
			 ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			String name1;
			
			while (res.next()) {
				name1 = res.getString(name);
				
//				name = res.getString("company_name");
				
				System.out.println(name+"\t");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("该数据不存在");
		}
	}
	
	
	
	public void deleteMysql(String sql){
		try {
			Statement statement = con.createStatement();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void close(){
	        try {
	            if (con != null ){
	            	con .close();
	            }
	            if (ps != null ){
	            	ps .close();
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
}
