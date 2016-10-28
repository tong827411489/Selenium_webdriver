package cn.sele;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.Test;



public class httpJsoup {
	
	public Document httpGet(String url,String param){
		Document doc = null;
		
		try {
			Connection conn = Jsoup.connect(url);
			conn.data(param);
			conn.timeout(10000);
			doc = conn.get();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return doc;
	}
	

	
	public void httpPostCookie(String url,String param){
		try {
			Connection conn = Jsoup.connect("http://192.168.0.132:8080/login/doLogin.html");
			conn.data("account","18867149072");
			conn.data("password","96e79218965eb72c92a549dd5a330112");
			conn.timeout(30000);
			conn.method(Method.POST);
			Response response = conn.execute();
			Map<String, String> cookies = response.cookies(); 
			//预审核
//			Document doc = Jsoup.connect("http://192.168.0.132:8080/service/saveMaterialsOrder.html?orderNo=nfdb2016051216004108&orderStatus=1&materialsId=11").cookies(cookies).timeout(20000).get();
			//数据化
//			Document doc1 = Jsoup.connect("http://192.168.0.186:9092/service/saveMaterialsOrder.html?orderNo=nfdb2016101216061814&orderStatus=2&materialsId=11").cookies(cookies).timeout(20000).get();
			//提交订单
//			Document doc2 = Jsoup.connect("http://192.168.0.186:9092/approval/approvalConfirm.html?orderNo=nfdb2016101216061814&flowId=&deptType=1").cookies(cookies).timeout(20000).get();
			
			
			Connection con = Jsoup.connect(url);
			con.data("orderNo",param);
			con.data("orderStatus","1");
			con.data("materialsId", "11");
			Document doc = con.cookies(cookies).timeout(20000).post();
			System.out.println(doc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	} 
	
	public httpJsoup httpGetCookie(String account,String loginInfo){
		httpJsoup j = new httpJsoup();
		try {
			Connection conn = Jsoup.connect("http://192.168.0.186:9092");
			conn.data("account",account);
			conn.data("loginInfo", loginInfo);
			conn.timeout(30000);
			conn.method(Method.GET);
			Response response = conn.execute();
			Map<String, String> cookies = response.cookies();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this;
	} 
	
	@Test
	public void test(){
		httpJsoup j = new httpJsoup();
		j.httpPostCookie("http://192.168.0.132:8080/service/saveMaterialsOrder.html","jqr2016092117545106");
//		j.httpPostCookie("http://192.168.0.132:8080/service/saveMaterialsOrder.html","orderNo=nfdb2016100911072283&orderStatus=2&materialsId=11");
//		j.httpPostCookie("http://192.168.0.186:9092/service/saveMaterialsOrder.html?orderNo=nfdb2016090720435832&orderStatus=1&materialsId=11");
//		Document doc = j.httpGet("http://www.baidu.com", "");
//		Assert.assertTrue(doc.toString().contains("百度"));
//		j.httpPostCookie("http://192.168.0.186:9092/service/saveMaterialsOrder.html", "orderNo=nfdb2015120817422457&orderStatus=1&materialsId=11");
//		j.httpPostCookie("http://192.168.0.186:9092/service/saveMaterialsOrder.html", "orderNo=nfdb2015120817422457&orderStatus=2&materialsId=11");
//		j.httpPostCookie("http://192.168.0.186:9092/service/saveMaterialsOrder.html", "orderNo=nfdb2015120817422457&flowId=&deptType=1");
//		Document doc = j.httpGet("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionCountry", "");
//		Assert.assertTrue(doc.toString().contains("俄罗斯"));
	}
}
