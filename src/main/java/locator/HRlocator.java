package locator;

public interface HRlocator {
	
	String hrregister = "//a[text()='机构注册']";  //主页注册
	String hrnextpage = "//div[contains(@class,'go')]/child::a";   //帐号注册页面下一页
	String companyname = "//input[@name='company.companyName']";   //企业名称
	String selectprovince = "//select[@id='province']";     //选择省份
	String selectarea = "//select[@id='area']";   //选择二级城市
	String selectcity = "//select[@id='city']";   //选择三级城市
	String requestName = "//input[@name='company.requestName']"; //公司名称
	String imgAuthCode = "//input[@id='imgAuthCode']";   //图形校验码
	String phone = "//input[@name='company.phone']";   //手机号码
	String phoneAuthCode = "//input[@name='company.authCode']";   //手机验证码
	String checkpassword = "//input[@onblur='checkPassword()']|//input[@onblur='checkPasswordAgain()']";  //密码及确认密码
	String registernextpage = "//a[text()='下一步']"; //页面填写信息下一页
	String companyLicencs = "//input[@id='companyLicencs']";  //传入文件
	String submit = "//a[@id='submit']"; //提交申请
	String Determine = "descendant::a[text()='确认']|//a[text()='确认']"; //确认按钮
	String companyname1  = "//p[text()='机构名称：%1$s']"; //注册成功提示
	String success = "//p[text()='你的申请正在审核中，审核结果会及时通过手机短信发送给你，请耐心等待！']";
}
