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
	
	//连接数据库
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
	
	//查询数据
	public  String selectSQL(String sql,String sqlName) { 
			String companyName = null;
	        ResultSet rs = null;  
	        try {  
	            ps = con.prepareStatement(sql);  
	            rs = ps.executeQuery(sql);
	            while (rs.next()) {
	            	companyName = rs.getString(sqlName);
					System.out.println(companyName);
				}
	            return companyName;
	        } catch (SQLException e) {  
	            e.printStackTrace();
	            return null;
	        }  
	          
	    }  
	
	//删除数据
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
	
	//关闭数据库连接
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
