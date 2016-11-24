package cn.sele;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class httpCookies {
	
	public Map<String,String> httpCookies(){
		try {
			Connection conn = Jsoup.connect("http://192.168.0.186:9092/login/doLogin.html");
			conn.data("account","18867149072");
			conn.data("password","96e79218965eb72c92a549dd5a330112");
			conn.timeout(30000);
			conn.method(Method.POST);
			Response response = conn.execute();
			Map<String, String> cookies = response.cookies(); 
			
			return cookies;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args){
		httpCookies h = new httpCookies();
		h.httpCookies();
	}
}
