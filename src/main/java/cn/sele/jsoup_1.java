package cn.sele;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;

public class jsoup_1 {

	public Document jsoup1(String url,String param){
		Document doc = null;
		try {
			Connection con = Jsoup.connect(url);
			con.data("wd",param);
			doc = con.get();
			return doc;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Document doc = null;
		jsoup_1 j = new jsoup_1();
		doc = j.jsoup1("http://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&oq=1&rsv_pq=ddcd42a000017866&rsv_t=0d0dTCSJuxNGKjWlvUMJypSuwU%2FQqfctLau5d9v15I5%2BbEvgbyekteywjfg&rqlang=cn&rsv_enter=0&inputT=11042&rsv_sug3=4&rsv_sug1=3&rsv_sug7=100&bs=1", "loadrunner");
		Assert.assertEquals(doc.toString().contains("LoadRunner基础入门教程_百度经验"), true);
		System.out.println(doc);
	}
}
